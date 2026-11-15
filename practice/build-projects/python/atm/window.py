import customtkinter as ctk


ctk.set_appearance_mode("dark")
ctk.set_default_color_theme("coffee.json")

app = ctk.CTk()
app.title("ATM")
app.geometry("600x600")


label = ctk.CTkLabel(app, text="Hello World")
label.pack(pady=5)

app.mainloop()