# To-Do List App (Pemrograman Mobile)

Aplikasi Android berbasis Native (Kotlin & Jetpack Compose) yang dirancang untuk membantu pengguna mencatat, mengelola, dan memantau tugas serta aktivitas harian secara praktis dan terorganisir.

---

## 📌 Pengertian Proyek
**To-Do List App** adalah aplikasi manajemen tugas harian yang dibangun menggunakan arsitektur modern Android (Material 3). Aplikasi ini memungkinkan pengguna untuk memantau produktivitas dengan fitur status progres tugas, pembagian kategori, serta penentuan tingkat prioritas (Tinggi, Sedang, Rendah).

---

## ✨ Fitur-Fitur Utama

### 1. Manajemen Tugas Harian (CRUD)
- **Tambah Tugas Baru**: Input judul tugas, deskripsi, pemilihan kategori, dan tingkat prioritas.
- **Tandai Selesai**: Checkbox interaktif dengan efek *strike-through* otomatis.
- **Hapus Tugas**: Menghapus tugas perorangan atau membersihkan seluruh tugas yang sudah tuntas dengan tombol *Hapus Tugas Selesai*.

### 2. Pengelompokan & Penyaringan (Filter)
- **Filter Status**: Filter berdasarkan *Semua*, *Aktif*, atau *Selesai*.
- **Filter Kategori**: Mengelompokkan aktivitas berdasarkan kategori (*Kuliah*, *Pribadi*, *Pekerjaan*, *Lainnya*).

### 3. Indikator Progres Real-Time
- Kartu progres dinamis (*LinearProgressIndicator*) dengan persentase penyelesaian tugas secara langsung.

### 4. Tingkat Prioritas Visual
- Badge warna prioritas:
  - 🔴 **Tinggi** (Merah)
  - 🟠 **Sedang** (Orange)
  - 🟢 **Rendah** (Hijau)

### 5. Penyimpanan Data Lokal (Persistence)
- Data tugas tersimpan aman di penyimpanan internal perangkat (*SharedPreferences JSON*), sehingga catatan tidak hilang meskipun aplikasi ditutup atau perangkat di-restart.

---

## 📁 Struktur Singkat Proyek
```plaintext
TodoListApp/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/example/to_dolist/
│   │       │   ├── MainActivity.kt           # Activity utama & inisialisasi aplikasi
│   │       │   ├── Navigation.kt             # Pengaturan navigasi layar
│   │       │   ├── model/
│   │       │   │   └── TodoItem.kt           # Data model tugas & enum prioritas
│   │       │   ├── data/
│   │       │   │   └── TodoStorage.kt        # Logika penyimpanan lokal (SharedPreferences JSON)
│   │       │   ├── ui/main/
│   │       │   │   └── MainScreen.kt         # Tampilan UI To-Do List (Jetpack Compose Material 3)
│   │       │   └── theme/                    # Pengaturan tema, tipografi, dan warna
│   │       └── AndroidManifest.xml           # Konfigurasi manifest aplikasi Android
│   └── build.gradle.kts                      # Dependensi modul aplikasi
├── gradle/                                   # Konfigurasi Gradle Wrapper
├── build.gradle.kts                          # Konfigurasi Gradle Root
├── settings.gradle.kts                       # Pengaturan modul proyek
└── README.md                                 # Dokumentasi proyek
```

---

## 🛠️ Teknologi yang Digunakan
- **Bahasa Pemrograman**: Kotlin
- **UI Toolkit**: Jetpack Compose & Material Design 3
- **Penyimpanan Lokal**: SharedPreferences dengan Serialisasi JSON
- **Build System**: Gradle 9.x dengan Kotlin DSL (`build.gradle.kts`)
- **Min SDK**: 24 (Android 7.0 Nougat ke atas)
- **Target SDK**: 36

---

## 🚀 Cara Menjalankan Aplikasi

### Di Android Studio:
1. Buka folder `TodoListApp` di **Android Studio**.
2. Sambungkan HP dengan kabel USB (aktifkan *USB Debugging* di *Opsi Pengembang*).
3. Klik tombol **Run (▶)** di toolbar atas.

### Menggunakan Terminal (ADB):
```bash
# Memberikan izin eksekusi script
chmod +x run_on_phone.sh

# Pasang dan buka langsung di layar HP
./run_on_phone.sh
```
