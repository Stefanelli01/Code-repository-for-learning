import json

#dados = {"nome": "Luiz", "idade": 18, "Senha": 123}

#with open("dados.json", "w", encoding="utf-8") as arquivo:
    #json.dump(dados, arquivo, ensure_ascii=False, indent=2)

with open("dados.json", encoding="utf-8") as arquivo:
    dados = json.load(arquivo)

print(dados["nome"])
print(type(dados))