## 📌 Introdução  
Dois sistemas implementados em Java para demonstrar o uso de **pilhas** e **filas**:  

1. **Navegador**  
   - Simula os botões "Voltar/Avançar" de um navegador web com histórico de páginas.  
2. **Hospitalar**  
   - Gerencia filas de atendimento médico com emissão de senhas e histórico.  

---

## 🛠️ Implementação  

### 🌐 Sistema de Navegador  
**Estruturas de Dados:**  
- Duas pilhas (`historicoVoltar` e `historicoAvancar`).  
- Fluxo:  
  - **Nova página:** Empilha em `historicoVoltar`.  
  - **Voltar:** Move topo de `historicoVoltar` para `historicoAvancar`.  
  - **Avançar:** Move topo de `historicoAvancar` de volta.  

**Recursos:**  
- Exibição formatada com `JLabel` e HTML.  
- Placeholder dinâmico no campo de URL.  
- Botões desabilitados quando as pilhas estão vazias.  

![Diagrama do Navegador](diagrama_sistemas.png)  

### 🏥 Sistema Hospitalar  
**Estruturas de Dados:**  
- Fila (`LinkedList`) para ordem FIFO.  
- Histórico (`ArrayList`) de senhas atendidas.  
- Contador sequencial para senhas (ex: `PAC-001`).  

**Fluxo:**  
1. Geração de senha → Adiciona à fila.  
2. Chamar próximo → Remove da fila e registra no histórico.  

![Fluxo Hospitalar](fluxo_hospitalar.png)  

---

## ✅ Testes  

### Navegador  
| Caso  | Descrição                                  | Resultado Esperado              |  
|-------|--------------------------------------------|----------------------------------|  
| TN-01 | Navegar → Voltar após múltiplas páginas    | Exibe página anterior correta   |  
| TN-02 | Voltar/Avançar sem histórico               | Botões desabilitados            |  

### Hospitalar  
| Caso  | Descrição                                  | Resultado Esperado              |  
|-------|--------------------------------------------|----------------------------------|  
| TH-01 | Gerar 5 senhas e chamar 3                 | Histórico mostra PAC-001 a 003  |  
| TH-02 | Chamar senha com fila vazia               | Exibe mensagem de erro          |  

---

## 📚 Lições Aprendidas  
- **Navegador:**  
  - Complexidade na sincronização entre pilhas.  
  - Renderização de HTML em componentes Swing.  
- **Hospitalar:**  
  - Imutabilidade do histórico de atendimentos.  
  - Escolha entre `LinkedList` vs `ArrayDeque`.  

**Dificuldades:** Validação de entradas vazias/mal formatadas.  
