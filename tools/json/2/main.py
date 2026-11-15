import json
import hashlib


def cadastrar_user():
    print("\n--- CADASTRO DE USUÁRIO ---")
    email = input("Digite o e-mail: ").strip()
    senha = input("Digite a senha: ").strip()
    senha_cripto = hashlib.sha256(senha.encode()).hexdigest()

    # 1. Tenta ler o arquivo JSON
    try:
        with open("users.json", "r", encoding="utf-8") as arquivo:
            users = json.load(arquivo)
    except FileNotFoundError:
        users = []

    # 2. Verifica se o e-mail já existe
    for user in users:
        if user["email"] == email:
            print("❌ E-mail já cadastrado!")
            return

    # 3. Adiciona e salva o novo usuário
    novo_usuario = {
        "email": email,
        "senha": senha_cripto,
    }
    users.append(novo_usuario)

    with open("users.json", "w", encoding="utf-8") as arquivo:
        json.dump(users, arquivo, indent=2)

    print("✅ Usuário cadastrado com sucesso!")


def fazer_login():
    print("\n--- LOGIN ---")
    email = input("Digite o e-mail: ").strip()
    senha = input("Digite a senha: ").strip()
    senha_cripto = hashlib.sha256(senha.encode()).hexdigest()

    # 1. Tenta abrir o arquivo para leitura
    try:
        with open("users.json", "r", encoding="utf-8") as arquivo:
            users = json.load(arquivo)
    except FileNotFoundError:
        print("❌ Nenhum usuário cadastrado até o momento.")
        return

    # 2. Procura o e-mail e compara as senhas
    for user in users:
        if user["email"] == email:
            if user["senha"] == senha_cripto:
                print("🎉 Login realizado com sucesso!")
            else:
                print("❌ Senha incorreta!")
            return  # Encontrou o e-mail, encerra a busca

    # Se percorreu a lista inteira e não achou
    print("❌ E-mail não encontrado!")


def menu():
    while True:
        print("\n=== SISTEMA DE LOGIN COM JSON ===")
        print("1 - Cadastrar novo usuário")
        print("2 - Fazer Login")
        print("3 - Sair")

        opcao = input("Escolha uma opção: ").strip()

        if opcao == "1":
            cadastrar_user()
        elif opcao == "2":
            fazer_login()
        elif opcao == "3":
            print("Saindo do sistema...")
            break
        else:
            print("Opção inválida, tente novamente.")


# Executa o programa
menu()