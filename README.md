# Simulador de Investimentos (Dev 🚧)

## Descrição do Projeto
Este projeto é um simulador de investimentos. Ele permite que os usuários cadastrem ativos de investimento (como ações, criptomoedas, fundos), realizem simulações de aportes periódicos e visualizem projeções do saldo ao longo do tempo. A aplicação segue uma arquitetura de microserviços e oferece uma interface simples e intuitiva para interação dos usuários.

## Funcionalidades

### 1. Cadastro de Ativos
- Cadastro de novos ativos de investimento com informações como nome, tipo de ativo (ação, criptomoeda, fundo) e valor inicial.
- Armazenamento dos ativos em um banco de dados relacional.

### 2. Simulação de Investimentos
- Simulação de aportes periódicos (mensais, trimestrais) e verificação das projeções de valor futuro.
- Consideração de uma taxa de retorno anual definida pelo usuário.

### 3. Visualização de Projeção
- Visualização gráfica da evolução dos investimentos ao longo do tempo, utilizando gráficos.

### 4. Gerenciamento de Usuários
- Cada usuário pode cadastrar sua própria carteira de ativos separadamente e visualizar apenas suas simulações.

## Arquitetura
A arquitetura é baseada em microserviços, sendo composta pelos seguintes componentes:

### 1. User Service
- Gerencia o registro, autenticação e informações dos usuários.
- Utiliza JWT para autenticar requisições.

### 2. Asset Service
- Responsável pelo gerenciamento dos ativos cadastrados pelos usuários.

### 3. Simulation Service
- Realiza as simulações de investimentos com base nos parâmetros fornecidos pelos usuários.

### 4. API Gateway
- Centraliza o acesso aos microserviços e valida as requisições dos usuários.

## Tecnologias Utilizadas
- **Backend**: Java, Spring Boot, Spring Security, Docker, JPA.
- **Frontend**: React, Next, Axios, Chart.js/Recharts.
- **Autenticação**: JWT (JSON Web Token).
- **API Gateway**: Spring Cloud Gateway.
- **Containerização**: Docker e Docker Compose.
- **Documentação**: Swagger para documentação das APIs.
- **Testes**: JUnit e Mockito para testes unitários.

## Instalação e Execução
1. Clone este repositório.
2. Certifique-se de ter Docker e Docker Compose instalados.
3. Utilize o Docker Compose para construir e executar os microserviços:
   ```sh
   docker-compose up
   ```
4. Acesse a interface web em `http://localhost:3000` para interagir com o simulador.


