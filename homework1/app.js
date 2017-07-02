// single state store
class Store {
    constructor(storage) {
        this.storage = storage; // assuming local storage will be passed in as storage
        // these are the key name you can use in Store
        this.CART_KEY = 'CART';
        this.QUEUE_KEY = 'QUEUE';
        this.FOODS_KEY = 'FOODS';
    }

    // you can get item by store.cartItems
    get cartItems() {
        return JSON.parse(this.storage.getItem(this.CART_KEY));
    }

    // to call setter, simply "assign" like store.cartItems = something
    set cartItems(cartItems) {
        this.storage.setItem(this.CART_KEY, JSON.stringify(cartItems));
    }

    get queue() {
        return JSON.parse(this.storage.getItem(this.QUEUE_KEY));
    }

    set queue(queue) {
        this.storage.setItem(this.QUEUE_KEY, JSON.stringify(queue));
    }

    get foods() {
        return JSON.parse(this.storage.getItem(this.FOODS_KEY));
    }

    set foods(foods) {
        this.storage.setItem(this.FOODS_KEY, JSON.stringify(foods));
    }
}

class Cart {
    // take dom element into JavaScript class to attachment events
    constructor(root, store) {
        this.root = root;
        this.store = store;
        this.items = this.store.cartItems;
        this.init();
    }

    init() {
        // Render a list of items under root element
        this.render();
        // TODO: attach remove cart items to rendered HTML
    }

    destroy() {
        // TODO: remove all the events attached from init
    }

    // remove an item from shopping cart
    removeItem(itemid) {
        // TODO: logic to remove an item from cart
        // call render method when the item is removed to update view
        if (this.items != null) {
            var newList = this.store.cartItems;
            var compare = itemid.name;
            debugger;
            for (var i = 0; i < this.items.length; i++) {
                if (this.items[i].name == compare) {
                    newList.splice(i, 1);
                }
            }
            this.store.cartItems = newList;
            this.items = newList;
        }
        this.render();
    }

    placeOrder() {
        // add item to statuses in store as status "in progress"
        if (this.items !== null) {
            var newQueueItems = [];

            // everything in 
            if (this.store.queue !== null) {
                for (var i = 0; i < this.store.queue.length; i++) {
                    newQueueItems.push(this.store.queue[i]);
                }
            }

            for (var i = 0; i < this.items.length; i++) {
                var new_item_added = true;
                for (var j = 0; j < newQueueItems.length; j++) {
                    var existing_queue_item_name = newQueueItems[j][0];
                    if (this.items[i][0] === existing_queue_item_name) {
                        var amount_to_add = Number(this.items[i][2]);
                        newQueueItems[j][2] += amount_to_add;
                        new_item_added = false;
                    }
                }
                if (new_item_added) {
                    newQueueItems.push([this.items[i][0], this.items[i][1], Number(this.items[i][2]), "In Progress!"]);
                }
            }
            this.store.queue = newQueueItems;
            this.order_placed = true;
            this.removeAllItems();
        }
    }

    // render a list of item under root element
    render() {
        console.log(this.store.cartItems);
        let tbody = this.root.querySelector('tbody');
        // using innerHTML to render a list of table row item under tbody
        tbody.innerHTML = this.renderListAsHTML(this.store.cartItems)
        let deleteButtons = this.root.querySelectorAll('.delete-button');
        let fakeList = this.store.cartItems;

        for (var i = 0; i < deleteButtons.length; i++) {
            let deleteBtn = deleteButtons[i];
            let scopedFakeList = fakeList;


            deleteBtn.addEventListener('click', () => {

                //alert('You are deleting' + deleteBtn);
                let item = this.items[parseInt(deleteBtn.id)];

                this.removeItem(item);
                // debugger;
                // // splice takes two arguments first being the index, second being
                // // the number of items removing
                // scopedFakeList.splice(0, 1);

                //  console.log(scopedFakeList);

            });
        }

        let removeAllButton = document.querySelector('.remove_all_button');
        removeAllButton.addEventListener('click', () => {
            this.removeAllItems();
        });

        let confirmOrderButton = document.querySelector('.confirm_order_button');
        confirmOrderButton.addEventListener('click', () => {
            this.placeOrder();
        });

    }



	/*
	 * Input is a list of cart items (that were added through checkout button)
	 *
	 * Output is a String (which is HTML itself)
	 */
    renderListAsHTML(list) {
        // replace with the for loop
        let result = "";
        for (var i = 0; i < list.length; i++) {
            result += '<tr><td>' + list[i].name + '</td><td>' + list[i].price + '</td><td><button class="delete-button" id=' + i + '>Delete</button></td></tr>';
        }

        return result;
    }
    /**
     * Class CartItem {
     *   String name;
     *   double price;
     * }
     *
     * public String rednerListAsHTML(List<CartItem> list) {
     *   // loop through the list and add it to single string
     *   String result = "";
     *   for (int i = 0; i < list.size(); i ++) {
     *     result += list.get(i).name + "-" + this.get(i).price;
     *   }
     *   return result;
     * }
     */
}

class CheckoutButton {
    constructor(root, store) {
        debugger;
        this.root = root;
        this.store = store;
        this.onClick = () => this.addItemToCart();
        this.init();
    }

    init() {
        this.root.addEventListener('click', this.onClick);
    }

    destroy() {
    }

    addItemToCart() {

        // hint: you can use `dataset` to access data attributes
        // See passing data from HTML to JavaScript from course note
        let cartItems = this.store.cartItems || [];
        // TODO: replace with actual item

        console.log(this.root.dataset);
        cartItems.push({
            name: this.root.dataset.name,
            price: this.root.dataset.price,
            description: this.root.dataset.description,
            imageURL: this.root.dataset.imageURL,
            ingredient: this.root.dataset.ingredient

        });
        console.log(cartItems);
        this.store.cartItems = cartItems;
    }
}

class StatusTable {
    // take dom element into JavaScript class to attachment events
    constructor(root, store) {
        this.root = root;
        this.store = store;
        init();
    }

    init() {
        // attach click event listener to table header row on each column
        render();
    }

    destroy() {
        // remove all the events attached from init
    }

    sort(columnName) {
        // after sorting the array of statuses, re render item to update view
        render();
    }

    // render rows of items under table using root.innerHTML
    render() {

    }
    removeAllItems() {
        this.store.cartItems = [];
        this.items = [];
        this.render();
    }


}

class Inventory {
    constructor(root, store) {
       
        this.root = root;
        this.store = store;
        this.init();
    }

    init() {
        this.render();
        // TODO: attach event listeners like click to remove items after rendering
    }

    destroy() {
        // TODO: remove event listeners added from the init above
    }

    removeItem(itemid) {
        // TODO: logic to remove an item from cart
        // call render method when the item is removed to update view
        if (this.items != null) {
            var newList = this.store.cartItems;
            var compare = itemid.name;
            debugger;
            for (var i = 0; i < this.items.length; i++) {
                if (this.items[i].name == compare) {
                    newList.splice(i, 1);
                }
            }
            this.store.cartItems = newList;
            this.items = newList;
        }
        this.render();
    }

    render() {
        // using innerHTML to render inventory listing
         let tbody = this.root.querySelector('tbody');
         tbody.innerHTML = '';
         let cartItems = this.store.cartItems || [];

         for (var i = 0; i < cartItems.length; i++) {

             let result = "";
                result = '<tr>'+
                            '<td width="400px">'+
                                '<table cellpadding="15">'+
                                    '<tr>'+
                                    '<td>'+  cartItems[i].name +
                                    '</td>'+
                                    ' </tr>'+
                                    '<tr>'+
                                        ' <td> Description: <br/>'+ cartItems[i].description +
                                        '</td>'+
                                    ' </tr>'+
                                    '<tr>'+
                                        ' <td>Price: $'+ cartItems[i].price +
                                        '</td>'+
                                    ' </tr>'+
                                ' </table>'+
                            '</td>'+
                        '<td  style="text-align:center">'+
                            '<img src="'+ cartItems[i].imageURL +'" width="350px"/></td>' +
                   '<td style="vertical-align:top">' + this.getIngredientAsHTML(cartItems[i].ingredient)  + '</td>'+
                    '<td style="text-align:center"> <button class="deleteItem-button" id=' + i + '>Delete</button></td>'+
                   '</tr>';

                    
             tbody.innerHTML += result;
               
         } 

        let deleteButtons = this.root.querySelectorAll('.deleteItem-button');
        let fakeList = this.store.cartItems;

        for (var i = 0; i < deleteButtons.length; i++) {
            let deleteBtn = deleteButtons[i];
            let scopedFakeList = fakeList;


            deleteBtn.addEventListener('click', () => {

                //alert('You are deleting' + deleteBtn);
                let item = this.items[parseInt(deleteBtn.id)];

                this.removeItem(item);
                // debugger;
                // // splice takes two arguments first being the index, second being
                // // the number of items removing
                // scopedFakeList.splice(0, 1);

                //  console.log(scopedFakeList);

            });
        }

        let removeAllButton = document.querySelector('.remove_all_button');
        removeAllButton.addEventListener('click', () => {
            this.removeAllItems();
        });
    }

    getIngredientAsHTML(ingredientList)
    {
        let ingList = ingredientList.split(",");
        let result = "<ul>"
        for (var i = 0; i < ingList.length; i++) {
            result += '<li>' + ingList[i] + '</li>';
        }
        result += "</ul>";
        return result;
    }

    
}


class Menu {
    constructor(root, store) {
        this.root = root;
        this.store = store;
        this.init();
    }

    init() {
        this.render();
    }

    render() {
        // TODO: render a list of food menu from store using innerHTML
    }
}

class CreateFood {
    constructor(root, store) {
      
        this.root = root; // root should be the container of the form itself
        this.store = store;
       
        this.init();
    }

    removeAllCartItems() {
         var newList = this.store.cartItems;
          
            for (var i = 0; i < this.items.length; i++) {
               
                    newList.splice(i, 1);
                
            }
            this.store.cartItems = newList;
            this.items = newList;
       
    }

    init() {

        let cartItems = this.store.cartItems || [];
        console.log(cartItems);
        // attach click event to create button
        let CreateItmBtn = document.getElementById('addItemBtn');
        if (CreateItmBtn) {
            CreateItmBtn.addEventListener("click", () => {
                this.createFood();
            });
        }

        let addNewIngredient = document.getElementById('addIngBtn');
        if (addNewIngredient) {
            addNewIngredient.addEventListener("click", () => {
                this.AddIngredients();
            });
        }
         
    }

    AddIngredients()
    {
         var currentIngredient = document.getElementById("listIngredient").innerHTML;
         var newIngredient = document.getElementById('itmIngr').value;
         
              currentIngredient +=  newIngredient + ',';
        
         document.getElementById("listIngredient").innerHTML = currentIngredient;
         document.getElementById('itmIngr').value ="";
    }

    createFood() {
        // will need to do querySelector to find out every single form element
        // to get their values before creating a new food
        // after creating a new food item, add it to store
        let cartItems = this.store.cartItems || [];
 
        var name = document.getElementById('itmName').value;
        var description = document.getElementById('itmDescription').value;
        var imageURL = document.getElementById('itmImage').value;
        var price = document.getElementById('itmPrice').value;
        var ingredient = document.getElementById("listIngredient").innerHTML;
// currentIngredient.substring(0,currentIngredient.length-1);
        var existItem = false;
        for (var i = 0; i < cartItems.length; i++) {
            if (name.toLowerCase() === cartItems[i].name.toLowerCase()) {
                existItem = true;
            }
        }

        if (!existItem) {
            cartItems.push({
                name: name,
                price: price,
                description: description,
                imageURL: imageURL,
                ingredient: ingredient.substring(0,ingredient.length-1) 
            });
            document.getElementById('itmName').value = "";
            document.getElementById('itmDescription').value = "";
            document.getElementById('itmImage').value = "";
            document.getElementById('itmPrice').value = "";
            document.getElementById('listIngredient').innerHTML = "";

            alert("Item added successfully!");
        }
        else
        {
            alert("This item is already exist!");
        }

        console.log(cartItems);
        this.store.cartItems = cartItems;
 
    }
}
// DOMContentLoaded event will allow us to run the following function when
// everything is ready. Think of the following code will only be executed by
// the end of document
document.addEventListener('DOMContentLoaded', () => {
    // use querySelector to find the table element (preferably by id selector)
    // let statusTable = document.querySelector('');
    // // use querySelector to find the cart element (preferably by id selector)


    let cart = document.querySelector('.cart-table');
    let checkoutButtons = document.querySelectorAll('.checkout-button');


    let store = new Store(window.localStorage);
    // if (table) {
    //     new StatusTable(table, store);
    // }


    if (cart) {
        new Cart(cart, store);
    }
    if (checkoutButtons && checkoutButtons.length) {
        for (var i = 0; i < checkoutButtons.length; i++) {
            new CheckoutButton(checkoutButtons[i], store);
        }
    }


    let createFood = document.querySelector('#create_new_item');
    if (createFood) {
        new CreateFood(createFood, store);
    }

    let inventory = document.querySelector('#inventory_table');
    if (inventory) {
       
        new Inventory(inventory, store);
    }
});