package service.agenda_eventos;
import model.Evento;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class AgendaEventosService {
    private List<Evento> eventos;
    private DateTimeFormatter formatarAno;
    private DateTimeFormatter formatarDiaSemana;

    public AgendaEventosService() {
        eventos = new ArrayList<>();
        formatarAno = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        formatarDiaSemana = DateTimeFormatter.ofPattern("EEEE", new Locale("pt", "BR"));
    }

    public void adicionarEvento(Evento evento) {
        eventos.add(evento);
    }

    public void removerEvento(String nome) {
        eventos.removeIf(evento -> evento.getNome().equalsIgnoreCase(nome));
    }

    public void listarEventos() {
        if (eventos.isEmpty()) {
            System.out.println("Nenhum evento na agenda.");
        } else {
            eventos.sort(Comparator.comparing(Evento::getData));

            System.out.println("Eventos na agenda:");
            for (Evento evento : eventos) {
                String dataFormatada = evento.getData().format(formatarAno);
                String diaDaSemana = evento.getData().format(formatarDiaSemana);
                System.out.println(evento.getNome() + " - " + dataFormatada + " (" + diaDaSemana + ")");
            }
        }
    }
}
