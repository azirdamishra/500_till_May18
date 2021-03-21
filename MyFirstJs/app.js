/*
behaviours and interactivity
setting up app.js, index.html and main.css is good practice -- progressive enhancement
If Js isn't enabled or supported, CSS and HTML will still work. If CSS doesn't work then HTML will def work
Like CSS we can add js directly to html but its better not to eg popups
semicolons can be usually omitted in js but its imp to understand where they are necessary
For the button made in html and properties given in css, we need to add an event handler to
make it do something
The below command is used so that Strict mode eliminates some JavaScript silent errors by changing them to throw errors
Strict mode prohibits some syntax likely to be defined in future versions of ECMAScript.
It prevents, or throws errors, when relatively “unsafe” actions are taken (such as gaining
access to the global object).
 */
'use strict'
const switcher = document.querySelector('.btn'); /* add reference to button */
/* below is the actual event handler */
switcher.addEventListener('click', function (){
    document.body.classList.toggle('dark-theme')

    let className = document.body.className;
    if(className === "light-theme"){
        this.textContent = "Dark";
    }else {
        this.textContent = "Light";
    }
    /*
    console messages don't appear on the webpage but they appear onto the developer tools area
    placed inside the event listener
    this is imp to see the output of your code
     */
    console.log('current class name ' + className );
    /*
    using the console we will be able to see that the value of className will be
    'light-theme dark-theme' instead  of 'dark-theme'. both the names are applied to body to
    switch to the dark theme but only the latter name takes precedence as can be seen in the
    Styles tab in dev tools
     */
});
/*
the toggle method in the above function to switch the element into the dark-theme mode
the button should be able to switch the format of the page into dark theme and update itself so
that it can later switch into light theme
 */

