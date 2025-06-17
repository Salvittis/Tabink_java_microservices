# TABINK - Sistema de Assessor Virtual Inteligente

Este repositório contém a implementação completa do sistema **TABINK_JAVA**, um projeto baseado em uma arquitetura de microsserviços com backend em **Java (Spring Boot)** e banco de dados Oracle (simulado com **H2**). O objetivo do sistema é fornecer assessoria virtual inteligente para plataformas de investimento, oferecendo recomendações personalizadas e educação financeira.

* * *

## 📦 Microserviços Incluídos

| Serviço | Linguagem | Porta Padrão | Responsabilidade Técnica |
| --- | --- | --- | --- |
| `ms-auth` | Java | 8081 | Autenticação e gerenciamento de usuários da plataforma |
| `ms-activity` | Java | 8082 | Registro de atividades do cliente  de investimento |
| `ms-profile` | Java | 8083 | Gerenciamento de perfil do cliente |
| `ms-portfolio` | Java | 8084 | Análise de desempenho de investimentos e impacto financeiro |
| `ms-advisor` | Java | 8085 | Geração de recomendações personalizadas e conteúdo educativo |
| `ms-management` | Java | 8086 | Painel de controle e regras de negócio da plataforma |

* * *

## ▶️ Execução (modo local com H2)

*   Java 17
*   Maven instalado
*   (Windows) Git Bash ou CMD

./start-all.bat

* * *

Cada microserviço possui documentação interativa no Swagger:

*   [http://localhost:8081/swagger-ui.html]() - Autenticação
*   [http://localhost:8082/swagger-ui.html]() - Atividades do Cliente
*   [http://localhost:8083/swagger-ui.html]() - Perfil do Cliente
*   [http://localhost:8084/swagger-ui.html]() - Análise de Portfolio
*   [http://localhost:8085/swagger-ui.html]() - Assessor Virtual
*   [http://localhost:8086/swagger-ui.html]() - Gerenciamento

* * *

Todos os serviços utilizam **H2 Database (in-memory)** para facilitar testes e simulações locais.

*   Interface H2: `http://localhost:{porta}/h2-console`
*   JDBC URL: `jdbc:h2:mem:testdb`

* * *

    InvestmentAdvisor/
    ├── ms-auth/
    ├── ms-activity/
    ├── ms-profile/
    ├── ms-portfolio/
    ├── ms-advisor/
    ├── ms-management/
    ├── start-all.bat
    ├── start-all.sh
    └── README.md
    

* * *

*   Arquitetura em camadas com REST APIs para cada domínio financeiro
*   Comunicação entre microsserviços via API Gateway (simulado)
*   Utilização de Swagger para documentação
*   Banco simulado com H2 por simplicidade (substituível por Oracle para produção)
*   Sistema de recomendações baseado em perfil do investidor
*   Gamificação para educação financeira
*   Projeto funcional e pronto para integração com plataformas de investimento

* * *

## ✅ Testes dos Microserviços - InvestmentAdvisor

Use os endpoints abaixo para testar cada microserviço do sistema InvestmentAdvisor. Utilize ferramentas como **Postman** ou **cURL**. Os exemplos incluem payloads adaptados para o contexto financeiro.

| Microserviço | Método | Endpoint | Descrição | Exemplo de JSON Body |
| --- | --- | --- | --- | --- |
| **ms-auth** | POST | `/auth/register` | Registrar novo usuário investidor | `{ "name": "João Silva", "email": "joao@email.com", "password": "123456" }` |
|  | POST | `/auth/login` | Fazer login na plataforma | `{ "email": "joao@email.com", "password": "123456" }` |
|  | GET | `/auth/me` | Buscar dados do usuário logado | Header: `Authorization: Bearer {token}` |
| **ms-activity** | POST | `/activity/log` | Registrar nova atividade do cliente | `{ "userId": 1, "description": "Investimento em CDB realizado", "type": "INVESTMENT" }` |
|  | GET | `/activity/user/1` | Listar atividades por usuário | — |
|  | GET | `/activity/all` | Listar todas as atividades | — |
|  | PUT | `/activity/1/status` | Atualizar status da atividade | `{ "status": "COMPLETED" }` |
| **ms-profile** | POST | `/profile` | Cadastrar perfil do investidor | `{ "userId": 1, "region": "Sudeste", "city": "São Paulo", "riskProfile": "MODERATE" }` |
|  | GET | `/profile/user/1` | Buscar perfil de um usuário | — |
|  | GET | `/profile/demographics` | Análise demográfica dos clientes | — |
| **ms-portfolio** | POST | `/portfolio/analysis` | Registrar análise de investimento | `{ "activityId": 1, "returnValue": 15000, "description": "Retorno positivo em fundos imobiliários" }` |
|  | GET | `/portfolio/activity/1` | Buscar análises de uma atividade | — |
| **ms-advisor** | GET | `/advisor/recommendations` | Obter recomendações personalizadas | — |
|  | POST | `/advisor/educate` | Registrar progresso educacional | `{ "userId": 1, "topic": "Renda Fixa", "progress": 75 }` |
| **ms-management** | GET | `/management/rules` | Buscar regras de negócio da plataforma | — |
|  | PUT | `/management/rules` | Atualizar regras do sistema | `{ "maxRiskLevel": 8, "autoRecommend": true }` |
|  | GET | `/management/logs` | Consultar logs do sistema | — |

Para acessar endpoints protegidos, use o token JWT obtido via `/auth/login`. Inclua o header:
`Authorization: Bearer {seu_token_jwt}`

* * *

## 🎯 Funcionalidades Específicas para Investimento

### Perfil do Investidor
- Classificação automática de perfil de risco (Conservador, Moderado, Agressivo)
- Análise demográfica para segmentação de clientes
- Histórico de investimentos e preferências

### Recomendações Inteligentes
- Algoritmos baseados em perfil do cliente e cenário macroeconômico
- Sugestões personalizadas de produtos financeiros
- Análise de oportunidades de mercado

### Educação Financeira Gamificada
- Sistema de pontuação por progresso educacional
- Conteúdo adaptado ao nível de conhecimento do usuário
- Recompensas por metas alcançadas

### Análise de Performance
- Acompanhamento de retorno dos investimentos
- Relatórios de impacto das recomendações
- Métricas de satisfação do cliente

* * *

## 🔧 Configuração para Produção

Para uso em produção com Oracle Database:

1. **Configurar conexão Oracle** em cada `application.yml`
2. **Ajustar variáveis de ambiente** para credenciais seguras
3. **Configurar Azure** para hospedagem dos serviços
4. **Implementar API Gateway** para roteamento centralizado
5. **Configurar monitoramento** e logs centralizados

* * *

*   Desenvolvido para o contexto de **Assessor Virtual Inteligente**
*   Baseado na arquitetura original do PowerGuard
*   Adaptado para plataformas de investimento e educação financeira
*   Mantém a robustez da arquitetura de microserviços Java

