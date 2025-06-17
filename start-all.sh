#!/bin/bash

# Script para inicializar todos os microserviços do InvestmentAdvisor

echo "=== INVESTMENT ADVISOR MICROSERVICES ==="
echo "Iniciando todos os microserviços..."
echo ""

# Verificar se Java 17 está instalado
java_version=$(java -version 2>&1 | head -n 1 | cut -d'"' -f2)
echo "Versão do Java: $java_version"

if [[ ! "$java_version" =~ ^17\. ]]; then
    echo "⚠️  AVISO: Java 17 é requerido para este projeto"
    echo "   Instale Java 17 ou configure JAVA_HOME adequadamente"
    exit 1
fi

echo ""
echo "✅ Java 17 detectado - prosseguindo..."
echo ""

# Lista de microserviços e suas portas
declare -A services=(
    ["ms-auth"]="8081"
    ["ms-activity"]="8082"
    ["ms-profile"]="8083"
    ["ms-portfolio"]="8084"
    ["ms-advisor"]="8085"
    ["ms-management"]="8086"
)

# Função para iniciar um microserviço
start_service() {
    local service=$1
    local port=$2
    
    echo "🚀 Iniciando $service na porta $port..."
    cd "$service"
    
    # Compilar o projeto
    echo "   Compilando..."
    mvn clean compile -q
    
    if [ $? -eq 0 ]; then
        echo "   ✅ Compilação bem-sucedida"
        
        # Iniciar o serviço em background
        echo "   🔄 Iniciando aplicação..."
        nohup mvn spring-boot:run -Dspring-boot.run.arguments="--server.port=$port" > "../logs/$service.log" 2>&1 &
        
        # Salvar o PID
        echo $! > "../pids/$service.pid"
        
        echo "   ✅ $service iniciado (PID: $!)"
        echo "   📋 Logs: logs/$service.log"
        echo "   🌐 URL: http://localhost:$port"
        echo "   📚 Swagger: http://localhost:$port/swagger-ui.html"
        echo ""
    else
        echo "   ❌ Erro na compilação do $service"
        echo ""
    fi
    
    cd ..
}

# Criar diretórios para logs e PIDs
mkdir -p logs pids

echo "Iniciando microserviços..."
echo ""

# Iniciar cada microserviço
for service in "${!services[@]}"; do
    start_service "$service" "${services[$service]}"
    sleep 2  # Pequena pausa entre inicializações
done

echo "=== RESUMO ==="
echo "Todos os microserviços foram iniciados!"
echo ""
echo "URLs dos serviços:"
for service in "${!services[@]}"; do
    port="${services[$service]}"
    echo "  $service: http://localhost:$port"
done

echo ""
echo "Para parar todos os serviços, execute: ./stop-all.sh"
echo "Para ver logs em tempo real: tail -f logs/{service}.log"
echo ""
echo "🎉 Investment Advisor está pronto para uso!"

