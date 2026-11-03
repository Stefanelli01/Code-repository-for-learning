import sqlite3

# Conecta (cria o arquivo se não existir)
conexao = sqlite3.connect("database.db")
cursor = conexao.cursor()

# Cria a tabela
cursor.execute("""
    CREATE TABLE IF NOT EXISTS users (
        id INTEGER PRIMARY KEY AUTOINCREMENT,
        name TEXT,
        age INTEGER
    )
""")

# Insere um aluno de teste
cursor.execute("INSERT INTO users (name, age) VALUES (?, ?)", ("Luiz", 18))
conexao.commit()  # Salva a alteração

# Busca os dados
cursor.execute("SELECT * FROM users")
resultados = cursor.fetchall()

# Mostra o resultado
print("Users encontrados no banco:", resultados)

conexao.close()