## Test
To play via browser, use http://localhost:8080/todo
To POST, PUT or DELETE use following script from developer console (change HTTP method and body as needed)

````
fetch('todo', {
  method: 'POST',
  body: JSON.stringify({
    title: 'Some more todo',
    completed: false,
    rank: 1
  }),
  headers: {
    'Content-type': 'application/json'
  }
})
.then(res => res.json())
.then(console.log)
````
