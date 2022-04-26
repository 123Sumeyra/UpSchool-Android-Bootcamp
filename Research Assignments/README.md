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
-Bu konu hakkında daha fazla bilgi alamak için [yazımı](https://ozugursumeyra.medium.com/kotlin-namespaceler-3348b16afe1a) okuyabilirsiniz.

### <a name="3"></a> Araştırma Projesi 3
- Font family dosyası nasıl oluşturulup kullanıyoruz? 
- Niçin böyle kullanımı tercih ediyoruz ?
- Font family projenizde deneyebilirsiniz?

### Cevap:
- **NİÇİN  KULLANIYORUZ?** </br>
Uygulamalarda belli bir fontu öne çıkarmak istediğiniz durumlarda kullanabilirsiniz. Kendi fontumuzu oluşturuyoruz şeklinde düşünebilirsiniz. Font dosyalarına ayrı ayrı ulaşmak yerine tek bir kaynak ulaşmamızı sağlar.Bu durum kaynak yönetimi açısından da avantaj sağlar bize. Ayrıca fontları custom olarak kullanmanın diğer bir yararı ise o fontun kaldırılma,güncellenme yada internetin olmadığı durumlarda ulaşılmama gibi olumsuz durumları ortadan kaldırır.
- **KULLANIMI?** 
  -  [Fonts](https://fonts.google.com/) sitesinden fontları bulabilirsin.
  - Bu fontların isimlerini değiştirmelisiniz. Küçük harf ve "_ " kullanınız. 
  - res klasörünün altında "font" adında bir klasör oluşturup fontlarınızı içine atabilirsiniz.
  - Daha sonra fontlar için bir xml dosyası oluşturmalısınız. Bunu genelde seçtiğimiz font adıyla yapıyoruz. Mesala fontlarımı  "akshar_bold.ttf", "akshar_medium.ttf"...
şeklinde ise  xml dosyamızın adını **akshar** vermek daha doğru olabilir. 
  - Daha sonra fontları bu xml dosyasında tanımlamalıyız. 

```xml
<font-family
    xmlns:android="http://schemas.android.com/apk/res/android">

     <font
        android:fontStyle="normal"
        android:fontWeight="200"
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
        android:fontStyle="normal"
        android:fontWeight="500"
        android:font="@font/akshar_medium" />
    <font
        android:fontStyle="normal"
        android:fontWeight="600"
        android:font="@font/akshar_semibold"/>

</font-family>

```

- **Font Weight için**
  - 100 Thin
  - 200 Light
  - 300 Book
  - 400 Regular
  - 500 Medium
  - 600 SemiBold
  - 700 Bold
  - 800 ExtraBold
  - 900 Heavy
- **Font Style için** 
  - normal veya
  -  italic.

Daha sonra  ``` <item name= "android:fontFamily" >@font/akshar</item>``` şeklinde fontunuzu genel temaya verebilirsiniz. Yada tek tek ```  android:fontFamily="@font/akshar" ``` verebilirsiniz.

activity.xml dosyası aşağıdaki gibidir.
```xml
 <TextView
        android:id="@+id/textView"
        android:text="@string/izmir"
        android:textFontWeight="700"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.422"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        style="@style/TextStyle" />

    <TextView
        android:id="@+id/textView2"
        android:text="@string/izmir"
        android:textFontWeight="200"
        android:textStyle="normal"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.498"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView"
        style="@style/TextStyle"
      />

    <TextView
        android:id="@+id/textView3"
        android:text="@string/izmir"
        android:textStyle="normal"
        android:textFontWeight="500"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.501"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView2"
        style="@style/TextStyle"/>

    <TextView
        android:id="@+id/textView4"
        android:text="@string/izmir"
        android:textFontWeight="400"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.501"
        android:textSize="20sp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView3"
        style="@style/TextStyle"/>

    <TextView
        android:id="@+id/textView5"
        android:text="@string/izmir"
        android:textFontWeight="600"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.501"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView4"
        style="@style/TextStyle"/>
```

style.xml ise
```xml
   <style name="TextStyle">
        <item name="android:layout_width">wrap_content</item>
        <item name="android:layout_height">wrap_content</item>
        <item name="android:layout_marginTop">70dp</item>
        <item name="android:textSize">20sp</item>
        <item name="android:textStyle">normal</item>
    </style>

```
Ayrıca [kodlara](https://github.com/123Sumeyra/UpSchool-Android-Bootcamp/tree/main/Projects/FontProject)  ve oluşan çıktıya bakabilirsiniz. <br/>
Daha ayrıntılı bilgi için [dökümantasyon](https://developer.android.com/guide/topics/ui/look-and-feel/fonts-in-xml) inceleyebilirsiniz.



### <a name="4"></a> Araştırma Projesi 4
- Property Animation ile ilgili olarak objectAnimator ile animator arasındaki farkı kısaca açıklayınız. </br>
### Cevap:
**Animator:**  Value animatorü temsil eder. </br>
**Object animator:**, Object animatorü temsil eder. Value animatorün alt sınıfıdır. Yani object animatorün yapabildiği her şeyi value animator yapabilir. </br>
- Peki neden kullanıyoruz o zaman object animatorü?
  - Hedef objenin üstünde animating sürecini çok daha kolay yapıyor. 

| What we can do             | Object Animator | Value Animator   
| -------------              | -------------   | --------    |
| `Basic Animation`          | YES             | YES         |
| `Property Animation`       | YES             | YES         |
| `Custom Animation`         | NO              | YES         |
| `Multiple Animation`       | NO              | YES         |
| `Multiple Object Animation`| NO              | YES         |
| `Repeate Animation`        | YES             | YES         |
| `Sequence Animation`       | NO              | NO          |


**Android Dev [Summit](https://www.youtube.com/watch?v=N_x7SV3I3P0&list=PLmEM3-F7iVMlm936VEVxlITwdn60XJQX0&t=355s)** etkinliğin de bu konu hakkında şöyle denmiş: </br>
**Object animator**  genelde property animation için kullanılır. Yani senin bir özelliğin vardır.Bunada animasyon vermek istiyorsundur o zaman kullanabilirsin.
**Value animator** custom animation için kullanılır. Ui daki özelliklerde kullanabilirsin.

Daha ayrıntılı bilgi için [dökümantasyon](https://developer.android.com/guide/topics/resources/animation-resource#Property) inceleyebilirsiniz.














