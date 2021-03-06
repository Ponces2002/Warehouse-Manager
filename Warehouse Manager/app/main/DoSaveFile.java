package ggc.app.main;

import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
import java.io.IOException;
import ggc.core.WarehouseManager;
import ggc.core.exception.MissingFileAssociationException;

/**
 * Save current state to file under current name (if unnamed, query for name).
 */
class DoSaveFile extends Command<WarehouseManager> {

  /** @param receiver */
  DoSaveFile(WarehouseManager receiver){
    super(Label.SAVE, receiver);
  }
  @Override
  public final void execute() throws CommandException{
    try{
      _receiver.save();
    }catch(MissingFileAssociationException e1){
      try{
        _receiver.saveAs(Form.requestString(Message.newSaveAs()));
      }catch(IOException | MissingFileAssociationException e){
        System.out.println("Erro");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
