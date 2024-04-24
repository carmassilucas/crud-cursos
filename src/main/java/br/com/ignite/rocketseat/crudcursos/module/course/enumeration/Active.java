package br.com.ignite.rocketseat.crudcursos.module.course.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Active {
    active(true),
    inactive(false);

    private final Boolean state;

    public static Active fromBoolean(Boolean state) {
        for (Active active : Active.values())
            if (active.state.equals(state))
                return active;
        throw new RuntimeException("Erro ao atualizar estado do curso");
    }
}
