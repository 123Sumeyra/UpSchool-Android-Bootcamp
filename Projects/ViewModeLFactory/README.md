## :bulb:ViewModelFactory

### :pushpin:Why a viewmodel factory is needed in Android? 
if you don't need an argument in the constructor, you can use just **ViewModelProviders.of()**. Because this method creates default **ViewModelProvider.Factory**.

İf we set some parametres in constructor and initialize it later.  We won't see error in build but we will face error in Run Time.  We can handle this problem with ViewModelFactory. If you want to read more information, just [click!!](https://medium.com/koderlabs/viewmodel-with-viewmodelprovider-factory-the-creator-of-viewmodel-8fabfec1aa4f). For this code, you can watch [it](https://www.youtube.com/watch?v=90ljEWTT5Xo)





