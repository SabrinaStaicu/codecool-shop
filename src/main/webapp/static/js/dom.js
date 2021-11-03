import {dataHandler} from "./data_handler.js";

export let dom = {
    init: function () {
        const wrapper = document.getElementById("products");
        wrapper.addEventListener("click", (event) =>{
            const isButton = event.target.nodeName === "BUTTON";
            if (!isButton) {
            } else {
                let url = event.target.getAttribute("href");
                console.log(url);
                let cartProductsCount= document.title.match(/(\d+)/);
                cartProductsCount == null ? cartProductsCount = 1 : cartProductsCount = parseInt(cartProductsCount.toString()) +1;
                document.title = "Codecool Shop(" + cartProductsCount + ")";
                let xhr = new XMLHttpRequest();
                xhr.open("POST", url, true);
                xhr.send();
                location.reload();
            }
        })

        document.getElementById("deleteCartItem").addEventListener("click", function (e) {
            e.preventDefault()
            let url = e.target.getAttribute("href");
            let xhr = new XMLHttpRequest();
            xhr.open("POST", url, true);
            xhr.send();
            location.reload();
        })

        // document.getElementById("placeOrder").addEventListener("click", function (e) {
        //     e.preventDefault()
        //     const xhr = new XMLHttpRequest(), formData = new FormData;
        //     // let cardHolderName = document.getElementById("cardholder_name").value;
        //     // let cardExpirationDate = document.getElementById("card_expiration_date").value;
        //     // let cardNumber = document.getElementById("card_number").value;
        //     // let cvv = document.getElementById("cvv").value;
        //     console.log("here");
        //     formData.append("card_holder_name", document.getElementById("cardholder_name").value)
        //     formData.append("card_expiration_date", document.getElementById("card_expiration_date").value);
        //     formData.append("card_number", document.getElementById("card_number").value);
        //     formData.append("cvv", document.getElementById("cvv").value);
        //
        //     xhr.open("POST", "/order_confirmation", true);
        //     xhr.send(formData);
        // })

        // document.getElementById("checkoutButton").addEventListener("click", function (e) {
        //     e.preventDefault()
            // const container = document.getElementById("container");
            // container.innerHTML = "";
            // container.innerHTML = `
            //     <form>
            //       <div class="form-row">
            //         <div class="form-group col-md-6">
            //           <label for="inputEmail4">Email</label>
            //           <input type="email" class="form-control" id="inputEmail4" placeholder="Email" required>
            //         </div>
            //         <div class="form-group col-md-6">
            //           <label for="inputName">Name</label>
            //           <input type="text" class="form-control" id="inputName" placeholder="Full Name" required>
            //         </div>
            //       </div>
            //       <div class="form-group">
            //         <label for="inputPhoneNumber">Address</label>
            //         <input type="tel" class="form-control" id="inputPhoneNumber" placeholder="+40-123-456-789" pattern="+[0-9]{2}-[0-9]{3}-[0-9]{3}-[0-9]{3}" required>
            //       </div>
            //       <div class="form-group">
            //         <label for="inputAddress">Address</label>
            //         <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St" required>
            //       </div>
            //       <div class="form-row">
            //         <div class="form-group col-md-6">
            //           <label for="inputCity">City</label>
            //           <input type="text" class="form-control" id="inputCity" required>
            //         </div>
            //         <div class="form-group col-md-4">
            //           <label for="inputState">State</label>
            //           <input type="text" class="form-control" id="inputState" required>
            //         </div>
            //         <div class="form-group col-md-2">
            //           <label for="inputZip">Zip</label>
            //           <input type="text" class="form-control" id="inputZip" required>
            //         </div>
            //       </div>
            //       <div class="form-group">
            //         <div class="form-check">
            //           <input class="form-check-input" type="checkbox" id="gridCheck">
            //           <label class="form-check-label" for="gridCheck">
            //             Check me out
            //           </label>
            //         </div>
            //       </div>
            //       <button type="submit" class="btn btn-primary">Go to payment</button>
            //     </form>
            // `;

        // })
    },

    placeOrder: function () {
        const xhr = new XMLHttpRequest(), formData = new FormData;
        // let cardHolderName = document.getElementById("cardholder_name").value;
        // let cardExpirationDate = document.getElementById("card_expiration_date").value;
        // let cardNumber = document.getElementById("card_number").value;
        // let cvv = document.getElementById("cvv").value;
        console.log("here");
        formData.append("card_holder_name", document.getElementById("cardholder_name").value)
        formData.append("card_expiration_date", document.getElementById("card_expiration_date").value);
        formData.append("card_number", document.getElementById("card_number").value);
        formData.append("cvv", document.getElementById("cvv").value);

        xhr.open("POST", "/order_confirmation", true);
        xhr.send(formData);
    }
}