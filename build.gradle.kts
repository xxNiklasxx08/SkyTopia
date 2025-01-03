plugins {
    id("java")
    id("idea")
    id("net.minecraftforge.gradle") version("[6.0.24,6.2)")
    id("org.parchmentmc.librarian.forgegradle") version("1.+")
    id("org.spongepowered.mixin") version("0.7.+")
}

group = "de._xxniklasxx_08"
version = "1.0-0"

repositories {
    maven {
        url = uri("https://dl.cloudsmith.io/public/geckolib3/geckolib/maven/")
        content { includeGroup("software.bernie.geckolib") }
    }
}

dependencies {
    minecraft("net.minecraftforge:forge:1.21-51.0.33")
    implementation("net.sf.jopt-simple:jopt-simple:5.0.4") {
        version { strictly("5.0.4") }
    }
    implementation(fg.deobf("software.bernie.geckolib:geckolib-forge-1.21:4.5.8"))
    annotationProcessor("org.spongepowered:mixin:0.8.5:processor")
}

minecraft {
    mappings("parchment", "2024.11.17-1.21.1")
    reobf = false
    copyIdeResources = true
    runs {
        configureEach {
            workingDirectory(project.file("run"))
            property("forge.logging.markers", "REGISTRIES")
            property("forge.logging.console.level", "debug")
        }
        create("client") {
            property("forge.enabledGameTestNamespaces", "skytopia")
        }
        create("server") {
            property("forge.enabledGameTestNamespaces", "skytopia")
            args("--nogui")
        }
        create("data") {
            args("--mod", "skytopia", "--all", "--output", "${file("src/generated/resources/")}", "--existing", "${file("src/main/resources/")}")
        }
    }
}

mixin {
    add(sourceSets.main.get(), "skytopia.refmap.json")
    config("skytopia.mixin.json")
}

sourceSets {
    forEach {
        val dir = layout.buildDirectory.dir("sourceSets/$it.name")
        it.output.setResourcesDir(dir)
        it.java.destinationDirectory = dir
    }
    main {
        resources { srcDir("src/generated/resources/") }
    }
}

java.toolchain {
    languageVersion = JavaLanguageVersion.of(21)
}

tasks {
    compileJava {
        options.release = 21
        options.encoding = Charsets.UTF_8.name()
    }
}