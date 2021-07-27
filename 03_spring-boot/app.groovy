@RestController
class ThisWillActuallyRun {

    @GetMapping("/")
    static String home() {
        return "Hello, World!"
    }

}
