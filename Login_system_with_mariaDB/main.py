import mysql.connector

def connect():

    return mysql.connector.connect(
        host="localhost",
        user="root",
        password="1974",
        database="sistema_auth"
    )

def create_table():
    connection = connect()
    cursor = connection.cursor()

    sql = """
    CREATE TABLE IF NOT EXISTS users (
        id INT AUTO_INCREMENT PRIMARY KEY,
        username VARCHAR(50) UNIQUE NOT NULL,
        password VARCHAR(100) NOT NULL
    )
    """
    cursor.execute(sql)
    connection.commit()
    cursor.close()
    connection.close()

def user_exist(user):
    connection = connect()
    cursor = connection.cursor()

    sql = "SELECT * FROM users WHERE username = %s"
    cursor.execute(sql, (user,))

    result = cursor.fetchone()

    cursor.close()
    connection.close()

    if result is None:
        return False
    else:
        return True

def register():
    print("\n ===-- REGISTER USER WITH MARIADB =====\n")
    user = input("Enter Username: ")

    if not user_exist(user) == True:

        password = input("Enter Password: ")

        connection = connect()
        cursor = connection.cursor()

        sql = "INSERT INTO users (username, password) VALUES (%s, %s)"
        data = (user, password)

        try:
            cursor.execute(sql, data)
            connection.commit()
            print("User Registered Successfully")

        except mysql.connector.Error as error:
            print(f"Error: {error}")

        finally:
            cursor.close()
            connection.close()

    else:
        print("User Already Exists")

def login():
    print("\n ===-- LOGIN --=== \n")
    user = input("Enter Username: ")

    if not user_exist(user) == False:
        password = input("Enter Password: ")

        connection = connect()
        cursor = connection.cursor()

        sql = "SELECT * FROM users WHERE username = %s AND password = %s"
        data = (user, password)

        cursor.execute(sql, data)
        result = cursor.fetchone()

        cursor.close()
        connection.close()

        if result:
            print("Login Successfully")
        else:
            print("Login Failed")

    else:
        print("User Doesn't Exist")

def menu():
    while True:
        print("\n ===-- MENU --=== \n")
        print("1. Register User")
        print("2. Login")
        print("3. Exit")

        option = int(input("Enter your choice: "))
        if option == 1:
            register()
        elif option == 2:
            login()
        elif option == 3:
            break
        else:
            print("Invalid Option")


if __name__ == "__main__":
    try:
        create_table()
        menu()

    except mysql.connector.Error as error:
        print(f"Error: {error}")


