import requests

URL = f"http://localhost:8080/people"

data = {
    "name": "Name from python client",
    "age": 23,
    "email": "python@test.com",
}

r = requests.post(url = URL, json = data)

if r.status_code == 200:
    print("added successfully")
else:
    print("Person not added")