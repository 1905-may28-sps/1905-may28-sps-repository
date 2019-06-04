# JSON - JavaScript Object Notation 

A data interchange format that is both human readable and easily parsed by comptuers. JSON is NOT the same thing as a JavaScript object, but is formated similarly to JS objects 

JS object:
```javascript

    var obj = {
        id: 1,
        name: 'myObject',
        biography: 'This is a JavaScript object'
    };

``` 

JSON string __representing__ this object:

```javascript
{
    "id" : 1,
    "name" : "myObject",
    "biography" : "This is a JavaScript object"
}
```

JSON can also represent arrays, and single values as follows
```javascript
    ["this is an array", 
    1,
    {
        "info" : "this is an object in my array"
    }
    ]
```

Some facts about JSON:
* it looks like a JS object but is NOT a JavaScript object, it is simply plain text formatted similarly to JS objects to help represent and exchange data 
* JSON cannot represent all things that JS objects can represent. JSON cannot hold functions nor undefined as values in objects(_null_ is a valid value, but lack of a value or an _undefined_ value is not valid)
* in order to convert an object in JavaScript to a JSON string, we use the native JS function JSON.stringify(obj)
* in order to convert a JSON string to a JavaScript object, we use the function JSON.parse(obj)