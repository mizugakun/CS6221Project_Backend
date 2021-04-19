package com.mangomanagement.demo.util;

import com.mangomanagement.demo.Entity.OrderDetail;
import com.mangomanagement.demo.Entity.OrderHistory;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ConsumptionPredictor {
    public double getAccurateCons_per_week(List<OrderHistory> histories, List<OrderDetail> details) {
        return getAccurateCons_per_day(getAverageConsList_per_day(histories, details)) * 7;
    }

    private List<Double> getAverageConsList_per_day(List<OrderHistory> histories, List<OrderDetail> details) {
        List<Double> res = new ArrayList<>();
        int sum_per_day = 0;
        int len = histories.size() - 1;
        for (int i = 0; i < len; i++) {
            if (Duration.between(histories.get(i).getOrderDate(),
                                 histories.get(i + 1).getOrderDate()).toDays() == 0) {
                sum_per_day += details.get(i).getAmount();
            } else {
                res.add(getAverageCons_per_day(
                        histories.get(i).getOrderDate(),
                        histories.get(i + 1).getOrderDate(),
                        details.get(i).getAmount() + sum_per_day
                ));
                sum_per_day = 0;
            }
        }
        return res;
    }

    private double getAverageCons_per_day(LocalDateTime start, LocalDateTime end, int amount) {
        long days = Duration.between(start, end).toDays();
        System.out.println("average between " +start.toString() + " and " +
                end.toString() + " is " + (double)amount/days);
        return (double)amount/days;
    }

    private double getAccurateCons_per_day(List<Double> averageConsumptions) {
        List<Double> validNumbers = new ArrayList<>();
        double average = getTotalAverageCons(averageConsumptions);
        double deviation = getDeviation(average, averageConsumptions);
        for(double con : averageConsumptions) {
            if (Math.abs(con - average) >= 2 * deviation) {
                continue;
            }
            validNumbers.add(con);
        }
        return getTotalAverageCons(validNumbers);
    }

    private double getDeviation(double average, List<Double> list) {
        double diff_square_sum = 0;
        for (double d : list) {
            double diff_square = Math.pow(d - average, 2);
            diff_square_sum += diff_square;
        }

        return Math.sqrt(diff_square_sum/ list.size());
    }

    private double getTotalAverageCons(List<Double> list) {
        double sum = 0;
        for (double d : list) {
            sum += d;
        }
        return sum/list.size();
    }

}
