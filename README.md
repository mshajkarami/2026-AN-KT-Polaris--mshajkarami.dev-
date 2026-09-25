# Polaris Team Portfolio — اپلیکیشن معرفی تیم پولاریس

<div align="center">

![Polaris Team](app/src/main/res/mipmap-xxhdpi/ic_launcher.webp)

**POLARIS SOFTWARE DEVELOPMENT COMPANY**  
*تیمی از برنامه‌نویس‌ها برای ساختن آینده‌ای بهتر*

[![Android](https://img.shields.io/badge/Platform-Android-3DDC84?style=flat&logo=android&logoColor=white)](https://developer.android.com)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.0+-7F52FF?style=flat&logo=kotlin&logoColor=white)](https://kotlinlang.org)
[![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-Material%203-4285F4?style=flat&logo=jetpackcompose&logoColor=white)](https://developer.android.com/jetpack/compose)
[![API](https://img.shields.io/badge/API-24%2B-blue.svg?style=flat)](https://android-arsenal.com/api?level=24)

</div>

---

## 🌟 درباره پروژه (About the Project)

اپلیکیشن **Polaris Team Portfolio** یک اپلیکیشن مدرن اندرویدی است که با استفاده از **Jetpack Compose** و **Material 3** توسعه داده شده است. این اپلیکیشن با هدف معرفی اعضای تیم نرم‌افزاری پولاریس (گروه Test)، تخصص‌ها، مسئولیت‌ها، پروژه‌ها و مسیر همکاری تیمی طراحی شده و دارای رابط کاربری کامپوز مدرن با پشتیبانی کامل از چینش راست‌به‌چپ (RTL) و تایپوگرافی اصیل **ایران‌یکان (Iran Yekan)** است.

---

## ✨ ویژگی‌های کلیدی (Key Features)

- **🎨 طراحی لوکس و دارک (Celestial Dark Theme):**  
  پالت رنگی تاریک و هماهنگ همراه با جلوه‌های طلایی پولاریس (`PolarisGold`)، گرادیان‌های عمودی ملایم و بوردرهای شیک.

- **🌌 بخش هیرو و آرت ژئومتریک (Celestial Hero Art):**  
  تصویرسازی آسمانی شامل کره ماه، حلقه‌های مداری، قله‌های کوهستان و ستاره قطبی طلایی که به صورت کد بومی در Canvas پیاده‌سازی شده است.

- **👥 کارت‌های اعضای تیم (Team Member Cards):**  
  نمایش تصاویر پرتره واقعی هر ۵ عضو تیم، شماره شناسایی، نقش انگلیسی و نام فارسی، بیوگرافی و تگ‌های تخصصی:
  1. **آرمین** — `Frontend Developer` (`HTML`, `CSS`, `JavaScript`)
  2. **ندا** — `Backend Developer` (`Node.js`, `Python`, `API`)
  3. **حسین** — `Fullstack Developer & Team Representative` (`React`, `Node.js`, `SQL`)
  4. **سارینا** — `UI/UX & Frontend` (`Figma`, `UI`, `React`)
  5. **علی** — `DevOps & Infrastructure` (`Linux`, `Docker`, `CI/CD`)

- **🔍 دیالوگ جزئیات عضو (Member Detail Dialog):**  
  امکان باز شدن مودال کامل با لمس هر کارت، شامل تصویر پرتره با کیفیت، مهارت‌ها، تکنولوژی‌ها، پروژه‌های مرتبط و دکمه‌های کپی و اتصال به گیت‌هاب، لینکدین و تلگرام.

- **👑 کارت نماینده تیم (Team Representative):**  
  معرفی نماینده منتخب گروه به همراه آواتار دایره‌ای با قاب طلایی، عنوان مسئولیت و توضیحات هماهنگی تیم.

- **🚀 دسته‌بندی مهارت‌ها و تکنولوژی‌ها (Skill Categories):**  
  نمایش توانمندی‌های تیم در ۴ حوزه: موبایل (Android/Kotlin)، فرانت‌اند و وب، بک‌اند و سرویس‌ها، و ابزارها و DevOps.

- **📋 پروژه‌ها و وضعیت اجرا (Project Showcase):**  
  کارت‌های معرفی پروژه‌ها به همراه تگ وضعیت، عضو مسئول، شرح کارکرد و قابلیت اشتراک‌گذاری.

- **🔄 مسیر همکاری ۷ مرحله‌ای (Collaboration Timeline):**  
  تایم‌لاین گام‌به‌گام فرآیند توسعه از تحلیل اولیه تا استقرار و پشتیبانی مداوم.

- **🔤 فونت اختصاصی ایران‌یکان (Iran Yekan Typography):**  
  اعمال سراسری وزن‌های مختلف فونت ایران‌یکان (Light، Regular، Medium، Bold) در تمامی استایل‌های Material 3 و کامپوننت‌های متنی.

---

## 🏗️ ساختار پروژه (Project Structure)

```text
app/src/main/
├── java/ir/polaris/test/
│   ├── MainActivity.kt             # اکتیویتی اصلی اپلیکیشن
│   ├── data/
│   │   └── TeamData.kt             # منبع داده‌های اعضا، مهارت‌ها، پروژه‌ها و متون وب‌سایت
│   ├── model/
│   │   ├── TeamMember.kt           # مدل داده‌ای اعضای تیم (همراه با photoRes)
│   │   ├── Project.kt              # مدل داده‌ای پروژه‌ها
│   │   ├── Responsibility.kt       # مدل مسئولیت‌های فردی و تیمی
│   │   └── SkillAndCollaboration.kt # دسته‌بندی مهارت‌ها و مراحل همکاری
│   └── ui/
│       ├── components/
│       │   ├── PolarisHeader.kt    # نوار هدر با برند و تب‌های جابه‌جایی
│       │   ├── PolarisHero.kt      # بخش هیرو با معرفی شرکت و دکمه‌ها
│       │   ├── PolarisHeroArt.kt   # آرت نجومی کدنویسی شده در Canvas
│       │   ├── MemberCard.kt       # کارت مدرن اعضای تیم با تصویر و گرادیان
│       │   ├── MemberDetailDialog.kt # دیالوگ جزئیات تکمیلی عضو
│       │   ├── TeamRepresentativeCard.kt # کارت معرفی نماینده با آواتار
│       │   ├── PolarisAboutSection.kt    # بخش درباره ما و ارزش‌های پولاریس
│       │   ├── SkillSection.kt     # بخش مهارت‌ها و تگ‌های تخصصی
│       │   ├── ProjectCard.kt      # کارت پروژه‌ها و مسئولیت‌ها
│       │   ├── ResponsibilityCard.kt # ماتریس مسئولیت‌ها
│       │   ├── CollaborationTimeline.kt # تایم‌لاین گام‌به‌گام
│       │   ├── PolarisContactSection.kt # بخش ارتباط و ایمیل
│       │   └── PolarisFooter.kt    # فوتر اختصاصی اپلیکیشن
│       ├── screens/
│       │   └── MainPortfolioScreen.kt # صفحه اصلی و اسکرول روان بین بخش‌ها
│       └── theme/
│           ├── Color.kt            # پالت رنگی تیره و طلایی
│           ├── Theme.kt            # تم پولاریس و اعمال TextStyle سراسری
│           └── Type.kt             # تعریف تایپوگرافی ایران‌یکان
└── res/
    ├── drawable/                   # تصاویر اعضا (member1 تا member5)
    ├── font/                       # فونت‌های ایران‌یکان (iran_yekan_regular, iran_yekan_l)
    └── values/                     # رشته‌ها، رنگ‌ها و استایل‌های سیستم
```

---

## 🛠️ پیش‌نیازها و نحوه اجرا (Getting Started)

### پیش‌نیازها:
- **Android Studio** (نسخه Ladybug / Meerkat یا جدیدتر)
- **JDK 17** یا بالاتر
- دستگاه فیزیکی یا شبیه‌ساز اندروید با **API 24** به بالا

### دستورات بیلد و تست:

1. **اجرای تست‌های واحد (Unit Tests):**
   ```bash
   ./gradlew testDebugUnitTest
   ```

2. **بیلد نسخه دیباگ (Build Debug APK):**
   ```bash
   ./gradlew assembleDebug
   ```
   فایل APK خروجی در مسیر زیر قرار می‌گیرد:
   ```text
   app/build/outputs/apk/debug/app-debug.apk
   ```

---

## 📜 لایسنس و حقوق اثر (License & Copyright)

© 2026 **POLARIS** • All Rights Reserved.  
*CODE • PEOPLE • A BRIGHTER TOMORROW*
