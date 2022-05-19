# RPN-Compiladores
Repositório do projeto de compiladores, criar uma calculadora com notação pós-fixa(RPN).

## Entregas
Esse repositório foi divido em 3 tags, a primeira tag (Task-1) é referente a primeira entrega/atividade, a segunda tag (Task-2) referente a segunda entrega/atividade e a terceira tag (Task-3) referente a terceira entrega.

### Task-1
Roteiro:
- rever a Aula 07 sobre notacao posfixa [reverse polish notation]
- Implementar uma linguagem RPN stacker em Java usando uma pilha como estrutura de dados
- Programa le um arquivo com a expressao em RPN e avaliar

#### Exemplo de entrada:
```
10
10
+
```

#### Saida: ``` 20 ```

### Task-2
Roteiro:
- rever a Aula 11 sobre introducao a analise lexica [scanning]
- evoluir o projeto da Task 01 para implementar uma feature de scanning:
   -- No geral, nosso Programa le um arquivo com a expressao em RPN e devolve a expressao avalliada
   -- a feature de scanning deve retornar uma lista de tokens
   -- a partir dessa lista de tokens que e realizada a interpretacao das expressoes com uma pilha
   -- a feature de scanning deve retornar um erro caso nao reconheca um "num" [numero] ou "op" [operator]

#### Exemplo de entrada [com sucesso]:
```
10
10
+
```

#### Saída:
```
Token [type=NUM, lexeme=10]
Token [type=NUM, lexeme=10]
Token [type=PLUS, lexeme=+]
20
```

#### Exemplo de entrada [com falha]:
```
10
s
+
```

#### Error: Unexpected character: ``` s ```

### Task-3
Agora a gramática da task 3 dará suporte a variáveis (id) e pode ser descrita da seguinte forma:
```
Expr = num
         |  id
         | Expr Expr op

op    = [+-/*]
num = [0-9]+
id = [_a-zA-Z][_a-zA-Z0-9]*
```

#### Exemplos de entrada
Entrada 1 sem nenhuma variável:
```
10
10
+
```
#### Saída: ```20```
Entrada 2 com a variável ```y``` sendo fornecida com a valor de ```10```:
```
10 
y 
+
```
#### Saída: ```20```
Entrada 3 com a variável ```w```, no entanto o valor de ```w``` não é fornecido:
```
10
w
+
```
#### Saída : Error: ```w``` cannot be resolved 
