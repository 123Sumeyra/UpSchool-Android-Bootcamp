# Araştırma Ödevleri:
- [Araştırma Projesi 1 - Lateinit](#1)
- [Araştırma Projesi 2 - Tools Namespace](#2)



### <a name="1"></a> Araştırma Projesi 1

- Lateinit neden kullanıyoruz?
- Lateinit kullanımından bahseder misiniz?
- Lateinit için bir örnek kullanım gösterir misiniz ?

### Cevap:
- Bir argümanın **null** gelme ihtimali varsa kesinlikle **nullable** kullanılmalı, Eğer bir argümanın null gelme ihtimalinin olmadığından eminseniz **lateinit** kullanabilirsiniz.
- Kelime anlamı olarak daha sonra ilk değerini vereceğim demektir. Primitive türler ile kullanılmaz ve **var** değişkeni ile beraber kullanılır.  `lateinit var` şeklinde.
#### Örnek Kullanım:
Şöyle bir senaryo düşünelim. Butona tıkladığımızda kullanıcının girdiği veriyi texView de gösterelim. Bunu yaparkende **lateinit** yapısını kullanalım.

```Kotlin
class MainActivity : AppCompatActivity() {
    private lateinit var enterName:EditText
    private lateinit var showName:TextView
    private lateinit var button: Button
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        enterName = findViewById(R.id.enterName)
        showName = findViewById(R.id.showName)
        button = findViewById(R.id.button)

        button.setOnClickListener {
            showName.text = enterName.text.toString()
        }

    }
}


```



### <a name="2"></a> Araştırma Projesi 2


- Layout dizini içinde xml dosyalarımız için kullandığımız namespace nedir ?
- Neden kullanılmaktadır ?
- Nasıl kullanılmalıdır ?
- Bir adet Tools (tools namespace) attribute kullanımını gösterir misiniz ? 


### Cevap:
- Layout dizininde xml dosyaları için kullandığımız namespaceler : **app**,**android**,**tools** şeklindedir.
- **app:**  Android için yazılmış destek kütüphanelerini kullanmak için  veya kendi tanımladığın custom özellikler içinde kullanılır.
- **android:** Android Sdk larından gelen özellikleri kullanmak için kullanılır
- **tools:** Genelde emülatörü çalıştırmadan nasıl görüneceğini görmek için kullanılır.Kod için bir önemi yoktur. Yani **Run time** da çalışmaz.
- Ayrıca bu namespace leri kullanabilmemiz için layout dizininde default olarak gelmektedir. 
DipNot: Eğer bu namespaceleri xml'e bağlandığı kısımları kaldrırısanız. Bu namespace ler sayesinde kullanabilidiğimiz özellikleri kullanamayız. 

```Kotlin
xmlns:android="http://schemas.android.com/apk/res/android"
xmlns:app="http://schemas.android.com/apk/res-auto"
xmlns:tools="http://schemas.android.com/tools"

```
### Örnek Kullanım:
Constraint Layout kullandığımız zaman kullandığımız **View** leri bağlamamız lazım. Bağlamazsak xml dosyasında o view'in altını çizer. Burada tools namespace çok kullanışlıdır. Bu özelliği kullanırız ve daha sonra bağlama işlemlerimizi yapabiliriz. Dilerseniz bağladıktan sonra bu kullanımı kaldırabilirsiniz o zaman hata gösterimi kalkar.
```Kotlin
tools:ignore="MissingConstraints"

```














