package com.home_server.ui.media;

import java.util.List;
import java.util.function.Predicate;

import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import com.home_server.boundary.media.RadioStationDTO;

@FacesConverter(value = "SelectItemToEntityConverter")
public class SelectItemToEntityConverter implements Converter{
// converter="SelectItemToEntityConverter">
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		 Object o = null;
	        if (!(value == null || value.isEmpty())) {
	            o = this.getSelectedItemAsEntity(component, value);
	        }
	        return o;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		String s = "";
        if (value != null) {
            s = ((RadioStationDTO) value).getId().toString();
        }
        return s;
	}

	private RadioStationDTO getSelectedItemAsEntity(UIComponent comp, String value) {
		RadioStationDTO item = null;

        List<RadioStationDTO> selectItems = null;
        for (UIComponent uic : comp.getChildren()) {
            if (uic instanceof UISelectItems) {
                Long itemId = Long.valueOf(value);
                selectItems = (List<RadioStationDTO>) ((UISelectItems) uic).getValue();

                if (itemId != null && selectItems != null && !selectItems.isEmpty()) {
                    Predicate<RadioStationDTO> predicate = i -> i.getId().equals(itemId);
                    item = selectItems.stream().filter(predicate).findFirst().orElse(null);
                }
            }
        }

        return item;
    }
}
