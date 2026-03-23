package com.Standa.weatherapp.views;

import com.Standa.weatherapp.service.WeatherService;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {

    public MainView(WeatherService service) {
        TextField cityInput = new TextField("Enter a city");
        Button searchBtn = new Button("Check Weather");
        Paragraph result = new Paragraph();

        searchBtn.addClickListener(e -> {
            if (!cityInput.getValue().isEmpty()) {
                var data = service.getWeather(cityInput.getValue());
                result.setText("In the city " + data.name() + " its " + data.main().temp() + "°C");
            } else {
                result.setText("Please enter a city!");
            }
        });

        add(cityInput, searchBtn, result);
    }
}
