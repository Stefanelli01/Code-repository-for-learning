from flask import Flask, render_template, request

app = Flask(__name__)

@app.route("/")

def home():
    name = "Luiz"

    return render_template("index.html", username=name)

@app.route("/sent", methods=["POST"])
def sent():
    recived = request.form["user_message"]

    return f"<h1> O pyhton recebeu sua mensagem: {recived} </h1>"

if __name__ == "__main__":
    app.run(debug=True)
