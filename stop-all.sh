#!/bin/bash

# Script para parar todos os microserviços do InvestmentAdvisor

echo "=== PARANDO INVESTMENT ADVISOR MICROSERVICES ==="
echo ""

# Verificar se o diretório pids existe
if [ ! -d "pids" ]; then
    echo "❌ Nenhum microserviço em execução encontrado"
    exit 1
fi

# Lista de microserviços
services=("ms-auth" "ms-activity" "ms-profile" "ms-portfolio" "ms-advisor" "ms-management")

echo "Parando microserviços..."
echo ""

# Parar cada microserviço
for service in "${services[@]}"; do
    pid_file="pids/$service.pid"
    
    if [ -f "$pid_file" ]; then
        pid=$(cat "$pid_file")
        
        if ps -p $pid > /dev/null 2>&1; then
            echo "🛑 Parando $service (PID: $pid)..."
            kill $pid
            
            # Aguardar o processo terminar
            sleep 2
            
            if ps -p $pid > /dev/null 2>&1; then
                echo "   ⚠️  Forçando parada do $service..."
                kill -9 $pid
            fi
            
            echo "   ✅ $service parado"
        else
            echo "⚠️  $service não estava em execução"
        fi
        
        # Remover arquivo PID
        rm "$pid_file"
    else
        echo "⚠️  Arquivo PID não encontrado para $service"
    fi
done

# Limpar diretórios
echo ""
echo "🧹 Limpando arquivos temporários..."
rmdir pids 2>/dev/null || true

echo ""
echo "✅ Todos os microserviços foram parados!"
echo ""
echo "Para reiniciar, execute: ./start-all.sh"

