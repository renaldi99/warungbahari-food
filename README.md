REST API Application Warung Bahari 😋🍲.
---
Food product api bahasa Indonesia 🇮🇩 build with java springboot

**Status** : Maintained 🚀

Documentation
---

| Field  | Description                                                                                              |
|--------|----------------------------------------------------------------------------------------------------------|
| key    | is a unique key used to access the next endpoint example  ```key : '8a8ab2af80a8ea650180a8eaa5640000'``` |
| page   | load a next of data if want to make pagination in your app                                               |
| sortBy | it will be sorting a data from key what you want to sort                                                 |
| limit  | is used to return a stream consisting of the elements of this stream, default limit = 3                  |
| direct | data will be returned and sort by ascending or descending                                                |


Endpoint Usage
---
**Base Url** : `http://localhost:8080/`

### Product

| Endpoint               | Usage                                      | Example                             | Method |
|------------------------|--------------------------------------------|-------------------------------------|--------|
| Get Products           | `/products`                                |                                     | GET    |
| Get Products by id     | `/products/:id`                            | `/products/1`                       | GET    |
| Get Products limit     | `/products?limit=size`                     | `/products?limit=5`                 | GET    |
| Get Products by page   | `/products?page=number`                    | `/products?page=1`                  | GET    |
| Get Products with sort | `/products?sortBy={key}&direct={asc/desc}` | `/products?sortBy=name&direct=desc` | GET    |
| Create Product         | `/products`                                | -                                   | POST   |
| Update Product         | `/products`                                | -                                   | PUT    |
| Delete Product         | `/products?productId=id`                   | `/products?productId=1`             | DELETE |

Show Case
---

* List Food Warung Bahari [(React Native)](https://github.com/renaldi99)

#### Credits
Copyright © 2020 Renaldi

Build With Heart on Fire ❤️‍🔥
ありがとうございました