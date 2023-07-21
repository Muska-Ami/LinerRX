import org.apache.tools.ant.filters.FixCrLfFilter
import org.apache.tools.ant.filters.ReplaceTokens
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("java")
    kotlin("jvm") version "1.9.0"
}

group = "moe.xmcn.qqguildbot"
version = "0.1.1"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots")
    maven("https://repo.extendedclip.com/content/repositories/placeholderapi")
    maven("https://maven.fastmirror.net/repositories/minecraft")
    maven("https://jitpack.io")
}

dependencies {
    // 本地
    //implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // 远程
    implementation("org.spigotmc:spigot-api:1.13-R0.1-SNAPSHOT")
    implementation("me.zhenxin:qqbot-sdk:1.2.0")
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.4.10")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.1")
    testImplementation(kotlin("test"))
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

tasks.compileJava {
    options.encoding = "UTF-8"
    sourceCompatibility = JavaVersion.VERSION_1_8.toString()
    targetCompatibility = JavaVersion.VERSION_1_8.toString()

}
tasks.compileTestJava {
    options.encoding = "UTF-8"
    sourceCompatibility = JavaVersion.VERSION_1_8.toString()
    targetCompatibility = JavaVersion.VERSION_1_8.toString()
}

// 替换资源文件的Tokens`config.groovy`
fun loadEnv(): Any {
    val configFile = file("config.groovy")
    val env = "prod"
    val confProp = groovy.util.ConfigSlurper(env).parse(configFile.toURL())
    //config.groovy配置文件,配置占位符 (@key@)
    val tokens = confProp.toProperties()
    logger.lifecycle("Tokens: $tokens")
    return tokens
}

fun delFiles(dir: String) {
    val configs = fileTree(dir)
    for (f in configs) {
        f.delete()
    }
}


tasks.processResources {
    delFiles("$buildDir/resources")
    filteringCharset = "UTF-8"
    filter(ReplaceTokens::class, "tokens" to loadEnv())
    filter(
        FixCrLfFilter::class,
        "eol" to FixCrLfFilter.CrLf.newInstance("lf"),
        "tab" to FixCrLfFilter.AddAsisRemove.newInstance("asis"),
        "tablength" to 4,
        "eof" to FixCrLfFilter.AddAsisRemove.newInstance("remove"),
        "fixlast" to true
    )

}

tasks.create<Jar>("fatJar") {

    // To avoid the duplicate handling strategy error
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    // To add all of the dependencies
    from(sourceSets.main.get().output)

    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().filter { it.name.endsWith("jar") }.map { zipTree(it) }
    })
}

//build命令依赖的其他命令
tasks.build {
    dependsOn(
        tasks.processResources,
        //"fatJar"
    )
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
