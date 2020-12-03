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
