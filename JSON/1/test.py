import json

nome = input("Digite o user: ")
validar = int(input("Digite a senha: "))

with open ("dados.json", "r") as arquivo:
    dados = json.load(arquivo)

if nome in dados[nome]:
    if validar in dados[senha]:
        print("login realizado")