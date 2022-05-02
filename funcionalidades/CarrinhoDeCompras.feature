#language: pt
#encoding: iso-8859-1

## Projeto04- Comércio Eletrônico - http://www.lojaexemplodelivros.com.br/

Funcionalidade: Carrinho de compras
	como um usuário da loja virtual
	eu quero montar um carrinho de compras
	para que eu possa comprar produtos
	
	Esquema do Cenário: Adicionar itens no carrinho de compras
	Dado Acessar a loja virtual
	E Selecionar um produto <nome_do_produto>
	E Informar a quantidade desejada <quantidade_do_produto>
	Quando Confirmar a compra do produto
	Então O produto é adicionado no carrinho de compras
	
	Exemplos:
	| nome_do_produto 					                  | quantidade_do_produto |
	| "[PRODUTO DE EXEMPLO] - Fortaleza Digital"	| 1			                |
	| "[PRODUTO DE EXEMPLO] - O Código da Vinci"  | 2                     |
	| "[PRODUTO DE EXEMPLO] - O Caçador de Pipas" | 1                     |
