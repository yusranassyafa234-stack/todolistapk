#!/bin/bash
echo "=========================================="
echo "  INSTALL & RUN TODO LIST APP KE HP       "
echo "=========================================="

# Cek apakah ADB mendeteksi HP
echo "Memeriksa koneksi HP (adb devices)..."
adb devices

DEVICE_COUNT=$(adb devices | grep -v "List of devices" | grep "device" | wc -l)

if [ "$DEVICE_COUNT" -eq "0" ]; then
    echo ""
    echo "⚠️  HP belum terdeteksi oleh ADB!"
    echo "Pastikan:"
    echo "1. Kabel USB sudah tersambung ke HP & laptop (Mode: Transfer File / MTP)"
    echo "2. 'Debugging USB' di HP sudah AKTIF (Opsi Pengembang)"
    echo "3. Pop-up 'Izinkan Debugging USB' di layar HP sudah diklik 'Izinkan (Allow)'"
    echo ""
    echo "Atau Anda bisa langsung pasang file APK manual yang ada di Desktop:"
    echo "📁 ~/Desktop/TodoListApp.apk"
    exit 1
fi

echo ""
echo "🚀 Memasang APK ke HP..."
adb install -r /home/yusrana/Desktop/TodoListApp.apk

echo "📱 Membuka aplikasi di layar HP..."
adb shell am start -n com.example.todolistapp/com.example.to_dolist.MainActivity

echo "✅ Selesai! Aplikasi To-Do List sudah aktif di layar HP Anda."
