package mx.uv.listi._9.Saludar;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
@RestController
public class SaludarControlador {

    Saludador parametro;
    @RequestMapping("/")
    public String home() {
        return "<ul>"
                + "<li><a href=\"/altas\">Altas</a></li>"
                + "<li><a href=\"/bajas\">Bajas</a></li>"
                + "<li><a href=\"/cambios\">Cambios</a></li>"
                + "<li><a href=\"/consultas\">Consultas</a></li>"
                + "</ul>";
    }


    //Ejemplo de Endpoints NO adecuados para un servicio RESTful    
    @RequestMapping("/altas")
    public String altas() {
        return "Altas";
    }

    @RequestMapping("/bajas")
    public String bajas() {
        return "bajas";
    }

    @RequestMapping("/cambios")
    public String cambios() {
        return "cambios";
    }

    @RequestMapping("/consultas")
    public String consultas() {
        return "consultas";
    }


       //Ejemplo de Endpoint SÍ adecuado para un servicio RESTful    
    @RequestMapping(value = "/Saludar", method = RequestMethod.POST)
    public String altasREST() {
        return "Altas";
    }

    @RequestMapping(value = "/Saludar", method = RequestMethod.DELETE)
    public String bajasREST() {
        return "bajas";
    }

    @RequestMapping(value = "/Saludar", method = RequestMethod.PUT)
    public String cambiosREST() {
        return "cambios";
    }

    @RequestMapping(value = "/Saludar", method = RequestMethod.GET)
    public String consultasREST() {
        return "consultas";
    }

    /*
    @GetMapping("/saludar1")
    public String saludarPath1(){
        return "xxx";
    }
    */

    //Falta de parámetro
    //------------------------------------------------------------
    @GetMapping(value = {"/saludar1", "/saludar1/{nombre}"})
    public Saludador saludarPath1(@PathVariable(required = false) String nombre) {
        if (nombre != null) {
            return new Saludador(nombre);
        }else{
            return new Saludador("Sin nombre");
        }
    }

    // Recepción de parámetros de tipo query string

    @GetMapping("/query")
    public void saludarQuery(@RequestParam String nombre){
        System.out.println("Saludo de " + nombre);
    }

    //------Recepción de parámetros estructurados
    @PostMapping("/crearSaludo")
    public String saludoCrear(@RequestBody Saludador s) {
        parametro = s;
        System.out.println(s.getContenido());
        return "Hola desde saludoCrear";
    }

    @GetMapping("/obtenerSaludo")
    public Saludador saludoObtener(){
        return parametro;
    }


}

