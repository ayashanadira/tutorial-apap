# Tutorial APAP

## Authors*

**Ayasha Nadira Widyadhana** - *1806191710* - *APAP-A*
---
## Tutorial 1
### What i have learned today
Saya belajar mengenai implementasi aplikasi Spring dan fitur-fitur pada Github

### Github
**1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?**

Issue tracker merupakan fitur Github sebagai tracker untuk project pada suatu repository. Setiap issues pada issue tracker yang dibuat oleh anggota tim dapat di-share dan menjadi wadah diskusi. Issue tracker dapat digunakan untuk tasks, bugs, perbaikan, atau pencatatan ide untuk improvement project. Masalah yang dapat diselesaikan issues adalah bugs, proses pull request, dan lainnya. 

**2. Apa perbedaan dari git merge dan git merge --squash?**

Perbedaan antara git merge dan git merge squash terletak pada commit. Pada git merge biasa, commit pada branch akan ditambahkan ke master/branch tujuan tanpa mengubah commit branch. Sementara pada git merge squash, commit yang ada pada branch akan dikombinasikan menjadi satu commit pada master/tujuan.

**3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu aplikasi? **

Git mendukung kolaborasi dan kerjasama antar developer dalam pengerjaan proyek karena masing-masing developer dapat mengetahui siapa saja dan apa saja kode yang diubah oleh developer lainnya. Dengan menggunakan git, seluruh versi source code dapat disimpan dan dapat berkontribusi pada proyek yang bersifat open-source.

### Spring
**4. Apa itu library & dependency?**

Library adalah kumpulan kode program atau method yang fokus pada task tertentu. Library dapat digunakan tanpa harus membuatnya dari awal. Dalam konteks programming, dependency adalah ketergantungan antar class atau antar kode. 

**5. Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?*

Maven merupakan tool untuk project management untuk Java-based project. Biasanya, Maven digunakan untuk projects build, mengatasi dependency, dan dokumentasi proyek. Dengan menggunakan maven, developer juga dapat mengintegrasikan projectnya dengan version control system seperti Git. Alternatif dari Maven adalah ANT dan Gradle.

**6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring framework?**

Spring dapat digunakan untuk pengembangan aplikasi enterprise, aplikasi terkait big data, aplikasi keamanan, dan transaction management. 

**7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya menggunakan @RequestParam atau @PathVariable?**

@RequestParam digunakan untuk mendapatkan suatu value dari form data dan secara otomatis meng-assign value tersebut ke parameter dalam suatu method. @PathVariable digunakan untuk mendapatkan suatu value dari URL. @RequestParam cocok untuk web dengan proses query atau searching.@PathVariable cocok digunakan bagi web dengan URL berisi value. @PathVariable juga memudahkan user untuk melakukan navigasi ke suatu page web tertentu. 

---
### What I did not understand
[] Implementasi dan cara kerja Maven
[] Detail cara kerja spring boot dan implementasinya di Github

---
## Tutorial 2
---
**1. Cobalah untuk menambahkan sebuah Hotel dengan mengakses link berikut:http://localhost:8080/hotel/add?idHotel=1&namaHotel=Papa%20APAP&alamat=Quanta%20Fasilkom&noTelepon=081xxx​Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi**

Muncul Whitelabel Error Page Service Error 500. Hal tersebut terjadi karena file HTML untuk add-hotel belum dibuat. Error tersebut diakibatkan karena method addHotel yang dipanggil oleh url /hotel/add tidak bisa melakukan return "add-hotel" karena belum ada template add-hotel. 

**2. Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa?Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat?**

Autowired merupakan implementasi dari konsep dependency injection. Pada class HotelController, @Autowired akan mengatasi persoalan terkait dependecy injection. @Autowired juga akan melakukan inisialisasi terhadap class HotelController seperti constructor, setter, dan getter melalui injection.

**3. Cobalah untuk menambahkan sebuah Hotel dengan mengakses link berikut:http://localhost:8080/hotel/add?idHotel=1&namaHotel=Papa%20APAP&alamat=Quanta%20FasilkomApa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.**

Hotel tidak akan bisa ditambahkan dan akan muncul page error dengan status Bad Request 400. Hal tersebut karena pada link di pertanyaan nomor 3, tidak ada parameter nomor telepon. Parameter nomor telepon tersebut merupakan parameter yang sifatnya required pada RequestParam untuk "noTelepon" dan nomor telepon merupakan atribut yang wajib ada untuk construct objek HotelModel.

**4. Jika Papa APAP ingin melihat Hotel dengan nama Papa APAP,link apa yang harus diakses?**

http://localhost:8080/hotel/view?idHotel=1 dengan mengganti angka '1' pada link menjadi id Hotel Papa APAP. Jika kita tidak mengetahui id Hotel dan hanya nama hotelnya saja, maka kode untuk method detailHotel dapat ditambahkan RequestParam untuk nama Hotel dan menambahkan parameter required=false untuk RequestParam idHotel. Linknya hotel Papa APAP menjadi berikut : http://localhost:8080/hotel/view?namaHotel=Papa APAP

**5. Tambahkan 1 contoh Hotel lainnya sesukamu.Lalu cobalah untuk mengakses http://localhost:8080/hotel/viewall​ ,apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.**

Pada page tersebut akan ditampilkan seluruh daftar dan informasi hotel yang sebelumnya telah di-add. 
![image](https://user-images.githubusercontent.com/45852173/94810293-0ab38800-041e-11eb-89bf-ce1f8a919d3c.png)

---
## Tutorial 3
---
**1. Pada class KamarDb​, terdapat ​method ​​findAllByHotelId​, apakah kegunaan dari ​method​ tersebut?**

Method yang akan mencari seluruh kamar yang ada pada suatu hotel dengan id tertentu. Seluruh pencarian akan di-return dalam bentuk list berisi objek KamarModel

**2.Pada class ​HotelController​, jelaskan perbedaan method ​addHotelFormPage​ dan ​addHotelSubmit​?**

Method addHotelFormPage membuat objek HotelModel baru dan mengembalikan tampilan form agar user dapat menambahkan atribut untuk construct objek hotel. Method addHotelSubmit akan menambahkan objek hotel yang sudah dilengkapi atribut ke database dan mengembalikan tampilan pesan sukses bahwa hotel berhasil ditambahkan. 

**3.Jelaskan kegunaan dari ​JPA Repository​!**

JPA (Java Persistance API) merupakan standar spesifikasi dari Java yang akan memetakan class pada Java dengan table relasional di database (SQL). JPA membantu proses manipulasi dan pengelolaan data dalam suatu database. Method JPA yang digunakan pada tutorial 3 ini diantaranya adalah save(), findAll, delete(), dan lainnnya. 

**4.Sebutkan dan jelaskan di bagian kode mana sebuah relasi antara HotelModel dan KamarModel dibuat?**

Relasi antara kedua model tersebut ada pada class HotelModel yang memetakan HotelModel dan KamarModel ke dalam hubungan one to many melalui annotation @OneToMany.

**5.Jelaskan kegunaan ​FetchType.LAZY, CascadeType.ALL​, dan ​FetchType.EAGER​!**

FetchType.LAZY akan load data objek dari database yang di-fetch hanya disaat membutuhkan saja. FetchType.LAZY dapat mempercepat dalam akses data. 

CascadeType.ALL berfungsi untuk memastikan bahwa data entitas yang mengalami operasi CRUD, maka entitas child juga akan mengikuti seluruh (ALL) perubahan yang terjadi pada entitas parent-nya. 

FetchType.EAGER akan load keseluruhan data objek dari database yang di-fetch seawal mungkin. 

---
## Tutorial 4
---
**1.Jelaskan perbedaan th:include dan th:replace!**

th:include akan memasukan elemen dengan atribut th:fragment tanpa memasukan tag dengan atribut th:fragment
th:replace akan menggantikan (replace) tag beratribut th:replace (host tag) dengan elemen beratribut th:fragment

**2.Jelaskan apa fungsi dari th:object!**

th:object berfungsi untuk men-spesifikasi suatu objek yang terikat dengan data dari form/elemen HTML

**3.Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?**

*{} merupakan selection variable expression yang digunakan dalam kombinasi dengan th:object. ${} adalah variable expression yang akan melakukan evaluasi terhadap ekspresi di dalam {}.

**4.Bagaimana kamu menyelesaikan latihan nomor 3?**

Saya menambahkan atribut th:text pada elemen HTML dengan expression ${pagename}. Pada HTML yang mengimplementasikan kode fragment tersebut, saya akan mendefinisikan pagename dengan judul halaman HTML tersebut.

---
## Tutorial 5
---
**1.Apa itu Postman? Apa kegunaannya?**

Postman adalah salah satu aplikasi/tools untuk melakukan pengujian API. Postman berfungsi sebagai REST Client untuk menjadi objek uji coba REST API. Karena fungsinya tersebut, Postman berperan penting dalam pengembangan suatu API.

**2.Apa fungsi dari anotasi @JsonIgnorePropertis dan @JsonProperty?**

@JsonIgnoreProperties adalah anotasi pada level class yang berfungsi untuk menandai suatu property/list of properties agar di-ignore. Sedangkan @JsonProperty adalah anotasi yang menentukan logical property yang digunakan paa proses serialization/deserialization JSON. @JsonProperty berfungsi untuk menandai method setter/getter non-standard untuk digunakan sesuai dengan JSON property. 

**3.Apa kegunaan atribut WebClient?**

WebClient berfungsi untuk melakukan HTTP request, dimana WebClient sendiri merupkan suatu klien yang bersifat non-blocking dan reaktif.

**4.Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?**

ResponseEntity berfungsi sebagai representasi HTTP response (termasuk elemen HTTP response seperti header, body, dan status) pada Spring. Sedangkan BindingResult adalah objek Spring yang mengandung hasil dari suatu prses validasi dan binding, termasuk mengandung suatu error yang kemungkinan terjadi. 

---
## Tutorial 6
---
**1.Jelaskan secara singkat perbedaan​ Otentikasi​ dan ​Otorisasi​! Di bagian mana (dalam kode yang telah anda buat) konsep tersebut diimplementasi?**

Otentikasi adalah proses identifikasi seseorang (user) pada sistem, sedangkan otorisasi adalah proses untuk menentukan wewenang/akses yang dimiliki user yang sudah diotentikasi terhadap sesuatu (fitur/method). Otentikasi diterapkan melalui method authenticate() pada AuthenticatioNManagerBuilder di method configAuthentication, sedangkan otorisasi diterapkan melalui method hasAuthority() pada method Configure di WebSecurityConfig.java.

**2.Apa itu ​BCryptPasswordEncoder​? Jelaskan secara singkat cara kerja dan tujuannya.**

BCryptPasswordEncoder merupakan salah satu class pada Spring Security. BCryptPasswordEncoder bertujuan untuk melakukan enkripsi password dengan
algoritma hashing BCrypt. Enrkipsi tersebut dilakukan agar untuk mengamankan data sensitif seperti password dengan membuat isi data password menjadi tidak terbaca/terlihat, sehingga tetap aman disimpan dalam database.

**3.Jelaskan secara singkat apa itu ​UUID ​beserta penggunaannya!**

UUID (Universally Unique Identifier) adalah kombinasi 32 karakter string, dimana kombinasi tersebut dibuat secara acak melalui algoritma tertentu. UUID biasa digunakan sebagai identifier unik dengan kemungkinan duplikasi yang sangat rendah, seingga UUID biasa digunakan sebagai primary key atau identifier unik suatu data. Dalam tutorial ini, UUID digunakan sebagai ID user.

**4.Apa kegunaan class ​UserDetailsServiceImpl.java​? Mengapa harus ada class tersebut padahal kita sudah memiliki class​ UserRoleServiceImpl.java​?**

UserDetailsServiceImpl.java berguna pada proses otentikasi user. Class ini mengimplementasi interface UserServiceDetail dari Spring Security. Class UserDetailsServiceImpl.java akan menghasilkan objek UserDetail, dimana objek tersebut akan mengandung informasi objek user dari database, otentikasi, dan otorisasi user sesuai role yang dimiliki oleh objek user. Sementara itu, UserServiceImpl.java adalah class untuk mengatur service dan mapping untuk UserModel. 

---
## Tutorial 7
---
**1. Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot sebagai ilustrasi dari apa yang Anda jelaskan.**

Untuk latihan nomor 1, saya menambahkan condition pada kode input di file index.js di folder Item agar menampilkan checkbox ketika bernilai true saja (sudah di-checked) dan menyembunyikan/hidden checkbox jika bernilai false (belum di-checked)

![image](https://user-images.githubusercontent.com/45852173/101056539-a9df3200-35bd-11eb-9cc3-e34c0d26db29.png)

Untuk latihan nomor 2, saya membuat button "Clear favorites" yang akan muncul dengan kondisi ketika array favItems memiliki length lebih dari 0. Ketika di-click, button akan memanggil ClearFavoriteItems yang akan me-reset array favItems menjadi array kosong dengan kode pada gambar berikut:

![image](https://user-images.githubusercontent.com/45852173/101053471-6800bc80-35ba-11eb-812c-a110d6608fad.png)

Untuk latihan nomor 3, saya melakukan modifikasi pada handleItemClick, dimana saya menghilangkan kode else agar item yang berada pada array favItems tidak di-splice sehingga tidak terhapus ketika item pada section List Movies di-click. Berikut adalah kode handleItemClick:

![image](https://user-images.githubusercontent.com/45852173/101054000-fe34e280-35ba-11eb-9196-a355883ee8b9.png)

Untuk latihan nomor 4, saya membuat folder baru dengan nama Toggle pada folder components. Berikut adalah screenshot kode index.js terkait objek const Switch (objek untuk button toggle switch) pada folder toggle:

![image](https://user-images.githubusercontent.com/45852173/101054475-84e9bf80-35bb-11eb-830a-1f61935cd98a.png)

Selanjutnya, saya menyusun constructor props pada App.js dan men-declare state show=true. Saya juga membuat fungsi handleToggleSwtich sebagai event handler ketika toggle di-click oleh user. 

![image](https://user-images.githubusercontent.com/45852173/101054577-9c28ad00-35bb-11eb-94d5-8ecda7361c59.png)

Berikut adalah pengaplikasian Toggle Switch.

![image](https://user-images.githubusercontent.com/45852173/101054615-a5b21500-35bb-11eb-80ad-3e0fe4e83e04.png)

Untuk latihan nomor 5, saya membuat folder baru dengan nama EmptyState pada folder components. Berikut adalah screenshot kode index.js terkait fungsi EmptyState yang menggunakan props:

![image](https://user-images.githubusercontent.com/45852173/101055534-91bae300-35bc-11eb-8418-983ad730f687.png)

Selanjutnya, saya melakukan modifikasi pada App.js dengan menambahkan condition dengan menggunakan EmptyState agar ketika array favItems memiliki length 0 maka EmptySpace yang akan di-return.

![image](https://user-images.githubusercontent.com/45852173/101055597-a0a19580-35bc-11eb-915f-cc6260ebac33.png)

**2. Menurut pemahaman kamu selama pengerjaan tutorial ini, apa perbedaan antara state dan props?**

State adalah objek untuk menyimpan data dalam suatu component, dimana state digunakan di lingkup suatu component itu sendiri. Sedangkan props adalah objek yang dapat berfungsi untuk "melempar" dan menyimpan value data antar component. Perbedaan mendasar antara state dan props adalah scopenya, dimana state hanya relevan digunakan dalam suatu component, sedangkan props digunakan untuk berkomunikasi antar component.

**3. Apa keuntungan menggunakan component (List, item) di react? Berikan contohnya!**

Kode React bersifat reusable akibat adanya component. Pada component List dan Item, masing-masing component tersebut memiliki logika sendiri dan kode komponen tersebut dapat digunakan dimana saja dalam app React sehingga membantu developer untuk membuat aplikasi dengan UI konsisten. 

**4. Menurut kamu, apa saja kelebihan menggunakan React dalam pengembangan web?**

-React dapat membuat pembangunan web yang dinamis menjadi lebih mudah karena kodenya yang bersifat reusable dan menghasilkan lebih banyak fungsionalitas. 
-Website yang menggunakan React akan memiliki kinerja yang lebih cepat karena adanya virtual DOM pada React. 
-Website yang menggunakan React menjadi lebih SEO friendly dibanding menggunakan JavaScript biasa karena React dapat berjalan di server dan adanya penggunaan virtual DOM dalam rendering halaman web pada browser. 

**5. Menurut kamu, apa saja kekurangan menggunakan React dalam pengembangan web?**

-Dokumentasi React kurang lengkap karena teknologi React yang terus berkembang secara cepat.
-React tidak compatible dengan browser versi lama, seperti contohnya Internet Explorer 8.

---
## Tutorial 8
---
**1. Ceritakan langkah - langkah yang kalian lakukan untuk ​solve ​LATIHAN no.1, dan mengapa kalian melakukan langkah - langkah tersebut?**

Saya melakukan setState pada state namaHotel, alamat dan nomorTelepon melalui potongan kode berikut: 

this.state ={
    //...
    namaHotel: "",
    alamat: "",
    nomorTelepon: ""
    //...
}

Melalui kode tersebut, ketika tombol Create ditekan, value dari setiap field pada stete akan berubah menjadi "" (string kosong).

**2. Jelaskan fungsi dari ​async ​dan ​await​!**

async bertujuan untuk mengubah fungsi menjadi asynchronous, sehingga suatu fungsi dapat berjalan tanpa perlu adanya reload page ulang. await bertujuan untuk menunda jalannya suatu proses/fungsi asynchronous sampai sesuatu yang di-await selesai. pada tutorial ini, contoh await dan async adalah fungsi hanldeSubmitAddHotel dan await dalam fungsi tersebut adalah menunggu proses APIConfig selesai, baru fungsi async handleSubmitAddHotel dapat kembali dilanjutkan. 

**3.Masukkan jawaban dari ​Screenshot ​yang diperintahkan di halaman 7​ pada Component Lifecyclepada pertanyaan ini.**

Ketika localhost:3000 dibuka pertama kali, dimana shouldComponentUpdate() tidak ada.
![Screenshot (56)](https://user-images.githubusercontent.com/45852173/101897364-02758700-3bdd-11eb-97c6-bdcb065eb689.png)

Ketika localhost:3000 dibuka kedua kali, dimana shouldComponentUpdate() muncul namun belum me-return nilai boolean.
![image](https://user-images.githubusercontent.com/45852173/101895903-bd505580-3bda-11eb-960c-67c07e3617cb.png)

Ketika saya mencoba menambahkan return true pada fungsi shouldComponentUpdate()
![image](https://user-images.githubusercontent.com/45852173/101895516-38fdd280-3bda-11eb-8009-fb3df84f6a30.png)


**4. Jelaskan fungsi dari ​​componentDidMount, shouldComponentUpdate,componentDidUpdate, componentWillReceiveProps,componentWillUnmount.Notes : Penjelasan harus mencantumkan “kapan fungsi dipanggil” dan “​use case ​apa saja yang biasanya menggunakan ​lifecycle method ​tersebut”.**

componentDidMount: Fungsi yang akan dieksekusi setelah render pada client side dan fungsi ini termasuk pada tahap mounting component lifecycle. 
Karena fungsi ini akan dieksekusi setelah render pada client side, waktu pemanggilan fungsi adalah ketika render HTML pertama kali dilakukan di client side. Salah satu use case fungsi ini adalah untuk melakukan update state agar mentrigger fungsi lain dalam component lifecycle. 

shouldComponentUpdate: Fungsi yang menandakan dan memberitahu react apakah suatu komponen terpengaruh current change state atau props dan memberitahu apakah komponen yang terpengaruh tsb perlu diupdate atau tidak. Fungsi ini akan me-return boolean value dengan default value adalah true. Waktu pemanggilan fungsi ini saat adanya update komponen atau perubahan state/props. Salah satu use case fungsi ini adalah ketika ada update komponen

componentDidUpdate: Fungsi yang meng-handle hal-hal eksternal dari environment React. Contoh hal eksternal tsb adalah browser atau API. Waktu pemanggilan fungsi ini ketika suatu komponen mengalami update dan proses rendering selesai dilakukan. Salah satu use case fungsi ini adalah ketika terdapat update komponen

componentWillReceiveProps: Fungsi yang menandakan dan memberitahu react terdapat perubahan pada component with props. Waktu pemanggilan fungsi ini setelah suatu props mengalami update dan sebelum render. Salah satu use case fungsi ini adalah ketika perubahan state/props dilakukan.

componentWillUnmount: Fungsi ini digunakan pada saat action yang berkaitan dengan delete/cancel/clean (contoh: menghapus/membatalkan sesuatu). Waktu pemanggilan fungsi ini setelah suatu component di-unmounting dari dom react. Salah satu use case fungsi ini adalah ketika ingin menghapus suatu komponen yang didefinisikan di componentDidMount. 