

document.addEventListener('DOMContentLoaded', () => {

    let calcButton = document.querySelector('#calc-button');
    calcButton.addEventListener('click', TipCalculate);
    function TipCalculate(e) {

        let percentage = document.querySelector('#tip_percentage').value;
        let bill = document.querySelector('#bill_Amt').value;

        var tipPetcentage = Number(percentage / 100);

        var tip = bill * tipPetcentage;
        var total_bill = Number(bill) + Number(tip);

        document.querySelector('#tip_amount').textContent = '$' + tip;
        document.querySelector('#bill_amount').textContent = '$' + total_bill;

    }
});