package com.vitalquiro.app.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

@Tag("canvas")
@JsModule("https://cdn.jsdelivr.net/npm/chart.js")
public class BarChartComponent extends Component {

    public BarChartComponent() {
        getElement().executeJs("""
            const ctx = this.getContext('2d');
            new Chart(ctx, {
                type: 'bar',
                data: {
                    labels: ['Jan', 'Feb', 'Mar', 'Apr', 'May'],
                    datasets: [
                        {
                            label: 'Berlin',
                            data: [189, 191, 291, 396, 501],
                            backgroundColor: '#4C6B7E'
                        },
                        {
                            label: 'London',
                            data: [138, 246, 248, 348, 352],
                            backgroundColor: '#7A9A92'
                        }
                    ]
                },
                options: {
                    responsive: true,
                    plugins: {
                        legend: { position: 'top' },
                        title: { display: true, text: 'View Events' }
                    }
                }
            });
        """);
    }
}
