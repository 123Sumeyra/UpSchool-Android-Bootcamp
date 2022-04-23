# Araştırma Ödevleri:
- [Araştırma Projesi 1 - Lateinit](#1)
- [Araştırma Projesi 2 - Tools Namespace](#2)
- [Araştırma Projesi 3 - Font Family](#3)
- [Araştırma Projesi 4 - Property Animation](#4)



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
- Ayrıca bu namespace leri kullanabilmemiz için layout dizininde default olarak gelmektedir.  </br>
**DipNot:** Eğer bu namespaceleri xml'e bağlandığı kısımları kaldrırısanız. Bu namespace ler sayesinde kullanabilidiğimiz özellikleri kullanamayız. 

```Kotlin
xmlns:android="http://schemas.android.com/apk/res/android"
xmlns:app="http://schemas.android.com/apk/res-auto"
xmlns:tools="http://schemas.android.com/tools"

```
### Örnek Kullanım:
Constraint Layout kullandığımız zaman  **View** leri bağlamamız lazım. Bağlamazsak xml dosyasında o view'in altını çizer. Burada tools namespace çok kullanışlıdır. Bu özelliği kullanırız ve daha sonra bağlama işlemlerimizi yapabiliriz. Dilerseniz bağladıktan sonra bu kullanımı kaldırabilirsiniz o zaman hata gösterimi kalkar.
```Kotlin
tools:ignore="MissingConstraints"

```

### <a name="3"></a> Araştırma Projesi 3
- Font family dosyası nasıl oluşturulup kullanıyoruz? 
- Niçin böyle kullanımı tercih ediyoruz ?
- Font family projenizde deneyebilirsiniz?

### Cevap:
- Öncelikle bir projeye başlamadan önce kullanacağın fontu belirlemelisiniz. Uygulamalarda belli bir fontu öne çıkarmak istediğiniz durumlarda kullanmalısınız. Ayrıca fontları custom olarak kullanmanın diğer bir yararı ise o fontun kaldırılma yada internetin olmadığı durumlarda ulaşılmama gibi olumsuz durumları ortadan kaldırı.
-  [Fonts](https://fonts.google.com/) sitesinden fontları bulabilirsin.
- Bu fontların isimlerini değiştirmelisiniz. Küçük harf ve "_ " kullanınız. 
- res klasörünün altında "font" adında bir klasör oluşturup fontlarınızı içine atabilirsiniz.
- Daha sonra fontlar için bir xml dosyası oluşturmalısınız. Bunu genelde seçtiğimiz font adıyla yapıyoruz. Mesala fontlarımı  "akshar_bold.ttf", "akshar_medium.ttf"...
şeklinde ise  xml dosyamızın adını **akshar** vermek daha doğru olabilir. 
- Daha sonra fontları bu xml dosyasında tanımlamalıyız. 
- font weigh için (400 -> regular için kullanılırken 700 -> bold weight için kullanılır.)
- font style normal veya italic.
```xml
<font-family
    xmlns:android="http://schemas.android.com/apk/res/android">

    <font
        android:fontStyle="normal"
        android:fontWeight="400"
        android:font="@font/akshar_light"
        />

    <font
        android:fontStyle="normal"
        android:fontWeight="400"
        android:font="@font/akshar_regular"
        />
    <font
        android:fontStyle="normal"
        android:fontWeight="700"
        android:font="@font/akshar_bold"
        />

    <font
        android:fontStyle="italic"
        android:fontWeight="400"
        android:font="@font/akshar_medium" />
    <font
        android:fontStyle="normal"
        android:fontWeight="700"
        android:font="@font/akshar_semibold"/>

</font-family>

```

Daha sonra  ``` <item name= "android:fontFamily" >@font/akshar</item>``` şeklinde fontunuzu genel temaya verebilirsiniz. Yada tek tek ```  android:fontFamily="@font/akshar" ``` verebilirsiniz.

activity.xml dosyası aşağıdaki gibidir.
```xml
 <TextView
        android:id="@+id/textView"
        android:text="@string/izmir"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.422"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        style="@style/TextStyle" />

    <TextView
        android:id="@+id/textView2"
        android:text="@string/izmir"
        android:textSize="20sp"
        android:textStyle="italic"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.498"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView"
        style="@style/TextStyle"
      />

    <TextView
        android:id="@+id/textView3"
        android:text="@string/izmir"
        android:textSize="20sp"
        android:textStyle="bold"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.501"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView2"
        style="@style/TextStyle"/>

    <TextView
        android:id="@+id/textView4"
        android:text="@string/izmir"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.501"
        android:textSize="20sp"
        android:textStyle="bold|italic"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView3"
        style="@style/TextStyle"/>

```

style.xml ise
```xml
    <style name="TextStyle">
        <item name="android:layout_width">wrap_content</item>
        <item name="android:layout_height">wrap_content</item>
        <item name="android:layout_marginTop">70dp</item>
        <item name="android:textSize">20sp</item>
    </style>

```
Ayrıca [kod](https://github.com/123Sumeyra/UpSchool-Android-Bootcamp/tree/main/Projects/FontProject) kodları ve oluşan çıktıya bakabilirsiniz.

## Soru(Hocam Size)


![deneme](https://user-images.githubusercontent.com/41166029/164948991-e6ad957d-dc7a-4eee-b638-1c02157c5099.png)
- 1)bu şekilde kullanıp bütün fontları daha iyi görmek varken neden xml oluşturup, onu kullanmayı tercih etmeliyiz. Yada her iki yöntemi de kullanabilir miyiz?
- 2)diyelim xml  seklinde font oluşturduk ama istedğimiz stile ulaşamyıyoruz o zaman **activity.xml** de ``` android:fontFamily="@font/akshar_light"``` şeklinde kullanabilir miyiz? Yani bu kullanım doğru bir kullanım mı olur?


### <a name="4"></a> Araştırma Projesi 4
-Property Animation ile ilgili olarak objectAnimator ile animator arasındaki farkı kısaca açıklayınız














