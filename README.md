# Tutorial APAP
# Authors*

**Ayasha Nadira Widyadhana** - *1806191710* - *APAP-A*
---
## Tutorial 1
### What i have learned today
Saya belajar mengenai implementasi aplikasi Spring dan fitur-fitur pada Github
### Github
**1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?**
<<<<<<< HEAD
Issue tracker merupakan fitur Github sebagai tracker untuk project pada suatu repository. Setiap issues pada issue tracker yang dibuat oleh anggota tim dapat di-share dan menjadi wadah diskusi. Issue tracker dapat digunakan untuk tasks, bugs, perbaikan, atau pencatatan ide untuk improvement project. Masalah yang dapat diselesaikan issues adalah bugs, proses pull request, dan lainnya. 
**2. Apa perbedaan dari git merge dan git merge --squash?**
Perbedaan antara git merge dan git merge squash terletak pada commit. Pada git merge biasa, commit pada branch akan ditambahkan ke master/branch tujuan tanpa mengubah commit branch. Sementara pada git merge squash, commit yang ada pada branch akan dikombinasikan menjadi satu commit pada master/tujuan.
**3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu aplikasi?**
Git mendukung kolaborasi dan kerjasama antar developer dalam pengerjaan proyek karena masing-masing developer dapat mengetahui siapa saja dan apa saja kode yang diubah oleh developer lainnya. Dengan menggunakan git, seluruh versi source code dapat disimpan dan dapat berkontribusi pada proyek yang bersifat open-source.
### Spring
**4. Apa itu library & dependency?**
Library adalah kumpulan kode program atau method yang fokus pada task tertentu. Library dapat digunakan tanpa harus membuatnya dari awal. Dalam konteks programming, dependency adalah ketergantungan antar class atau antar kode. 
**5. Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?**
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
**1. Cobalah untuk menambahkan sebuah Hotel dengan mengakses link berikut:http://localhost:8080/hotel/add?idHotel=1&namaHotel=Papa%20APAP&alamat=Quanta%20Fasilkom&noTelepon=081xxx​Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi**

Muncul Whitelabel Error Page Service Error 500. Hal tersebut terjadi karena file HTML untuk add-hotel belum dibuat. Error tersebut diakibatkan karena method addHotel yang dipanggil oleh url /hotel/add tidak bisa melakukan return "add-hotel" karena belum ada template add-hotel. 

**2. Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa?Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat?**

Autowired merupakan implementasi dari konsep dependency injection. Pada class HotelController, @Autowired akan mengatasi persoalan terkait dependecy injection. @Autowired juga akan melakukan inisialisasi terhadap class HotelController seperti constructor, setter, dan getter melalui injection.

**3. Cobalah untuk menambahkan sebuah Hotel dengan mengakses link berikut:http://localhost:8080/hotel/add?idHotel=1&namaHotel=Papa%20APAP&alamat=Quanta%20FasilkomApa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.**

Hotel tidak akan bisa ditambahkan dan akan muncul page error dengan status Bad Request 400. Hal tersebut karena pada link di pertanyaan nomor 3, tidak ada parameter nomor telepon. Parameter nomor telepon tersebut merupakan parameter yang sifatnya required pada RequestParam untuk "noTelepon" dan nomor telepon merupakan atribut yang wajib ada untuk construct objek HotelModel. 

**4. Jika Papa APAP ingin melihat Hotel dengan nama Papa APAP,link apa yang harus diakses?**

http://localhost:8080/hotel/view?idHotel=1 dengan mengganti angka '1' pada link menjadi id Hotel Papa APAP.
Jika kita tidak mengetahui id Hotel dan hanya nama hotelnya saja, maka kode untuk method detailHotel dapat ditambahkan RequestParam untuk nama Hotel dan menambahkan parameter required=false untuk RequestParam idHotel. Linknya hotel Papa APAP menjadi berikut : http://localhost:8080/hotel/view?namaHotel=Papa APAP

**5. Tambahkan 1 contoh Hotel lainnya sesukamu.Lalu cobalah untuk mengakses http://localhost:8080/hotel/viewall​ ,apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.**
Pada page tersebut akan ditampilkan seluruh daftar dan informasi hotel yang sebelumnya telah di-add. 
![image](https://user-images.githubusercontent.com/45852173/94810293-0ab38800-041e-11eb-89bf-ce1f8a919d3c.png)
