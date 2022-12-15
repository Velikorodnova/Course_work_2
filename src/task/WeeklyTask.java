package task;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyTask extends Task {
    public WeeklyTask(String header, String info, LocalDateTime dateTime, Type type) {
        super(header, info, dateTime, type);
    }

    @Override
    public boolean nextTime(LocalDate date) {
        boolean result = false;
        if (date.isBefore(this.getDateTime().toLocalDate())) {
            result = false;
        }
        LocalDate tmp = this.getDateTime().toLocalDate();
        while (!tmp.isAfter(date)) {
            if (date.isEqual(tmp)) {
                result = true;
            }
            tmp = tmp.plusWeeks(1);
        }
        return result;
    }
}
