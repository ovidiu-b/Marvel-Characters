package es.openbank.dev.dependencies;

public class Dependencies {

    public static class AndroidTest {
        public static final String archCoreTest = "androidx.arch.core:core-testing:" + Versions.Test.archCore;
        public static final String core = "androidx.test:core:" + Versions.Test.core;
        public static final String coreKtx = "androidx.test:core-ktx:" + Versions.Test.core;
        public static final String espressoCore = "androidx.test.espresso:espresso-core:" + Versions.Test.espressoCore;
        public static final String fragmentNav = "androidx.fragment:fragment-testing:" + Versions.Test.fragment;
        public static final String navigation = "androidx.navigation:navigation-testing:" + Versions.Androidx.navigation;
        public static final String junit = "androidx.test.ext:junit:" + Versions.Test.junit;
        public static final String mockk = "io.mockk:mockk:" + Versions.Test.mockk;
        public static final String runner = "androidx.test:runner:" + Versions.Test.runner;
        public static final String truth = "com.google.truth:truth:0.44";
        public static final String rules = "androidx.test:rules:1.4.0";
    }

    public static class Androidx {
        public static final String appcompat = "androidx.appcompat:appcompat:" + Versions.Androidx.appcompat;
        public static final String constraintlayout = "androidx.constraintlayout:constraintlayout:" + Versions.Androidx.constraintlayout;
        public static final String lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:" + Versions.Androidx.lifecycle;
        public static final String livedataKtxExtensions = "androidx.lifecycle:lifecycle-livedata-ktx:" + Versions.Androidx.lifecycle;
        public static final String lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:" + Versions.Androidx.lifecycle;
        public static final String material = "com.google.android.material:material:" + Versions.Androidx.material;
        public static final String navigation = "androidx.navigation:navigation-ui-ktx:" + Versions.Androidx.navigation;
        public static final String navigationFragment = "androidx.navigation:navigation-fragment-ktx:" + Versions.Androidx.navigation;
        public static final String recyclerView = "androidx.recyclerview:recyclerview:" + Versions.Androidx.recyclerview;
        public static final String roomCompiler = "androidx.room:room-compiler:" + Versions.Androidx.room;
        public static final String room = "androidx.room:room-runtime:" + Versions.Androidx.room;
        public static final String roomKtx = "androidx.room:room-ktx:" + Versions.Androidx.room;
        public static final String viewPager2 = "androidx.viewpager2:viewpager2:" + Versions.Androidx.viewPager2;
        public static final String swipeRefreshLayout = "androidx.swiperefreshlayout:swiperefreshlayout:" + Versions.Androidx.swipeRefreshLayout;
    }

    public static class Dagger {
        public static final String core = "com.google.dagger:dagger:" + Versions.dagger;
        public static final String coreCompiler = "com.google.dagger:dagger-compiler:" + Versions.dagger;
        public static final String androidCompiler = "com.google.dagger:dagger-android-processor:" + Versions.dagger;
        public static final String androidSupport = "com.google.dagger:dagger-android-support:" + Versions.dagger;
    }

    public static class Kotlin {
        public static final String coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:" + Versions.Kotlin.coroutines;
        public static final String coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:" + Versions.Kotlin.coroutines;
        public static final String coroutineTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:"+ Versions.Kotlin.coroutines;
        public static final String ktxCore = "androidx.core:core-ktx:" + Versions.Kotlin.ktx;
        public static final String stdlibJdk7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:" + Versions.Kotlin.kotlin;
    }

    public static class Retrofit {
        public static final String core = "com.squareup.retrofit2:retrofit:" + Versions.retrofit;
        public static final String moshiConverter = "com.squareup.retrofit2:converter-moshi:" + Versions.retrofit;
    }

    public static class OkHttp {
        public static final String core = "com.squareup.okhttp3:okhttp:" + Versions.okHttp;
        public static final String httpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:" + Versions.okHttp;
    }

    public static class Moshi {
        public static final String core = "com.squareup.moshi:moshi:" + Versions.moshi;
        public static final String codegen = "com.squareup.moshi:moshi-kotlin-codegen:" + Versions.moshi;
    }

    public static class Glide {
        public static final String core = "com.github.bumptech.glide:glide:" + Versions.glide;
        public static final String compiler = "com.github.bumptech.glide:compiler:" + Versions.glide;
    }
}
