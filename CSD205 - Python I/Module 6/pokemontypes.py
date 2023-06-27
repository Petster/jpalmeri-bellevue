pokemonTypes = {
    "Pikachu": "Electric",
    "Charizard": "Fire",
    "Blastoise": "Water",
    "Venusaur": "Grass",
    "Eevee": "Normal",
    "Gyrados": "Water",
    "Mimikyu": "Psycic",
    "Groudon": "Ground",
    "Lugia": "Dragon",
    "Jigglypuff": "Normal"
}

for name in pokemonTypes:
    print(f"{name}")

pokecheck = input("Select a Pokemon to Check Its Type: ")

if pokecheck in pokemonTypes.keys():
    print(f"{pokecheck}'s Type is {pokemonTypes[pokecheck]}!")
else:
    print(f"'{pokecheck}' Is Not On The List! Try Again!")