# 🚀 Projeto de Automação de Testes - SauceDemo (Swag Labs)

## 🎯 Objetivo do Projeto
O objetivo principal deste projeto é implementar uma suíte de testes automatizados ponta a ponta (E2E) para o e-commerce fictício [SauceDemo](https://www.saucedemo.com/). A automação visa garantir a estabilidade e a qualidade dos fluxos mais críticos da aplicação, minimizando falhas em cenários que impactam diretamente a experiência do usuário e o negócio, como o processo de autenticação e o fluxo completo de finalização de compras.

---

## 📋 Cenários de Teste Cobertos

* **Autenticação:**
    * Login e Logout utilizando usuário e senha válidos.
    * Tentativa de login com usuário inválido (validação de bloqueio e mensagens de erro).
* **Gerenciamento do Carrinho:**
    * Adição de produtos ao carrinho de compras.
    * Remoção de produtos do carrinho.
* **Fluxo de Compra (Checkout):**
    * Fluxo completo: Inserção de produtos no carrinho -> Preenchimento dos dados de envio -> Revisão do pedido -> Checkout e finalização da compra com sucesso.

---

## 🛠️ Tecnologias e Ferramentas Utilizadas

* **Linguagem:** Java (JDK 11 ou superior)
* **Framework de Automação:** Selenium WebDriver
* **Framework de Testes:** JUnit 5 (ou TestNG)
* **Gerenciador de Dependências:** Maven
* **Padrão de Projeto:** Page Object Model (POM)
* **IDE de Desenvolvimento:** Eclipse

---

## 📌 Pré-requisitos para Execução

Para importar, compilar e rodar os testes a partir do Eclipse, certifique-se de ter os seguintes itens configurados em sua máquina:

1. **Java Development Kit (JDK):** Versão 11 ou superior instalada e configurada nas variáveis de ambiente (`JAVA_HOME`).
2. **Eclipse IDE:** Eclipse IDE para desenvolvedores Java (recomendado Eclipse 2020 ou superior com suporte nativo ao Maven).
3. **M2Eclipse (Maven Integration for Eclipse):** Geralmente já vem instalado nas versões recentes do Eclipse. Caso não tenha, instale via *Eclipse Marketplace*.
4. **Navegador Web:** Google Chrome (ou seu navegador de preferência) instalado.
5. **Acesso à Internet:** Necessário para o Maven baixar as dependências do Selenium e JUnit no primeiro carregamento.

---

## 🚀 Como Executar o Projeto no Eclipse

### 1. Importando o Projeto para o Eclipse
1. Abra o **Eclipse IDE**.
2. Vá em **File > Import...**
3. Selecione **Maven > Existing Maven Projects** e clique em *Next*.
4. No campo *Root Directory*, clique em *Browse* e selecione a pasta raiz onde o projeto foi salvo.
5. Certifique-se de que o arquivo `pom.xml` está selecionado e clique em **Finish**.
6. O Eclipse irá baixar todas as dependências automaticamente (acompanhe a barra de progresso no canto inferior direito).

### 2. Executando os Testes

* **Executar a suíte completa:** Clique com o botão direito sobre a pasta raiz do projeto ou sobre o arquivo `pom.xml` -> Selecione **Run As > Maven test**.
  
* **Executar uma classe de teste específica:**
  Abra a classe de teste desejada (ex: `LoginTest.java`), clique com o botão direito em qualquer parte do código -> Selecione **Run As > JUnit Test**.

---

## 📐 Estrutura do Projeto (Page Object Model)

O projeto está estruturado de forma a separar a lógica dos testes dos elementos da tela, facilitando a manutenção:

├── src/main/java
│   └── pages          # Elementos da tela e ações (botões, campos, cliques)
│       ├── LoginPage.java
│       ├── InventoryPage.java
│       ├── CartPage.java
│       └── CheckoutPage.java
├── src/test/java
│   └── tests          # Scripts de teste, massa de dados e validações (Asserts)
│       ├── LoginTest.java
│       ├── CartTest.java
│       └── CheckoutTest.java
├── pom.xml            # Arquivo de configuração do Maven (dependências do Selenium/JUnit)
└── README.md


---

## 👩‍💻 Autor

Luis Camacho — profissional Analista QA em automação de testes, utilizando Java com framework Selenium e JUnit.