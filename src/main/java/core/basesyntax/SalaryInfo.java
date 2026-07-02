package core.basesyntax;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SalaryInfo {
    public String getSalaryInfo(String[] names, String[] data, String dateFrom, String dateTo) {
    StringBuilder result =  new StringBuilder();
        result.append("Report for period ");
        result.append(dateFrom);
        result.append(" - ");
        result.append(dateTo);
        result.append(System.lineSeparator());
        for (String name : names) {
            int salary = 0;

            for (String record : data) {
                String[] fragments = record.split(" ");
                if (name.eguals(fragments[1]))  {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                    LocalDate recordDate = LocalDate.parse(fragments[0], formatter);
                    LocalDate fromDate = LocalDate.parse(dateFrom, formatter);
                    LocalDate toDate = LocalDate.parse(dateTo, formatter);

                    if (!recordDate.isBefore(fromDate) && !recordDate.isAfter(toDate)) {
                        int hours = Integer.parseInt(fragments[2]);
                        int rate = Integer.parseInt(fragments[3]);
                        salary += hours * rate;
                    }
                }
            }
            result.append(name).append(" - ").append(salary).append(System.lineSeparator());
        }
        return result.toString().trim();
    }
}
