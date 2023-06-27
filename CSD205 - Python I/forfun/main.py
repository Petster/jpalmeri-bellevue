import tkinter as tk

#init window
window = tk.Tk()
window.geometry("350x100")

#do stuff
entry = tk.Entry(fg="black", bg="white", width=25)
entry.pack()

nameLabel = tk.Label(text="", fg="white")
nameLabel.pack()

def displayName():
    if(entry.get() != ""):
        nameLabel.config(text=entry.get(), bg="green")
        entry.delete(0, tk.END)
    else:
        nameLabel.config(text="Error: Empty Input", bg="red")

def closeApp():
    window.destroy()

button = tk.Button(
    text="Click Me!",
    bg="green",
    fg="white",
    command=displayName
).pack()


exitButton = tk.Button(
    text="Exit",
    bg="red",
    fg="white",
    command=closeApp
).pack()





#execute loop
window.mainloop()