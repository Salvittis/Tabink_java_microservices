@echo off
echo Iniciando todos os microserviços InvestmentAdvisor...

start cmd /k "cd ms-auth && mvn spring-boot:run"
start cmd /k "cd ms-activity && mvn spring-boot:run"
start cmd /k "cd ms-profile && mvn spring-boot:run"
start cmd /k "cd ms-portfolio && mvn spring-boot:run"
start cmd /k "cd ms-advisor && mvn spring-boot:run"
start cmd /k "cd ms-management && mvn spring-boot:run"

echo Todos os serviços foram iniciados em janelas separadas.
