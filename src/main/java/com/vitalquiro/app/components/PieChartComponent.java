package com.vitalquiro.app.components;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

@Tag("canvas")
@JsModule("https://cdn.jsdelivr.net/npm/chart.js")
public class PieChartComponent extends Component {

    public PieChartComponent() {
        getElement().executeJs("""
            const ctx = this.getContext('2d');
            new Chart(ctx, {
                type: 'pie',
                data: {
                    labels: ['System 1', 'System 2', 'System 3', 'System 4', 'System 5', 'System 6'],
                    datasets: [{
                        label: 'Response Times',
                        data: [12.5, 12.5, 12.5, 12.5, 12.5, 12.5],
                        backgroundColor: [
                            '#4C6B7E',
                            '#7A9A92',
                            '#F7C75C',
                            '#E0E0E0',
                            '#FF6384',
                            '#36A2EB'
                        ]
                    }]
                },
                options: {
                    responsive: true,
                    plugins: {
                        title: {
                            display: true,
                            text: 'Response Times'
                        }
                    }
                }
            });
        """);
    }
}
