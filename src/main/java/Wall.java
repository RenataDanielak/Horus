import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Wall implements Structure, CompositeBlock{

    private List<Block> blocks;

    //Potrzebny do napisania testow jednostkowych
    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return blocks.stream()
                .filter(block -> block.getColor().equals(color))
                .findFirst();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return blocks.stream()
                .filter(block -> block.getMaterial().equals(material))
                .collect(Collectors.toList());
    }

    @Override
    public int count() {
        return blocks.size();
    }

    @Override
    public String getColor() {
        //Mam wątpliwości, czemu interfejs main.CompositeBlock rozszerza interfejs main.Block, czy nie wystarczylo by powiazanie,
        // ze jeden interfes zwaraca obiekty implementujace drugi interfejs, w przypadku kompozytu, ktory slada sie z
        // z wielu blokow, w ktorym kazdy moze miec inna strukture i kolor, nie bardzo wiadomo, ktory kolor i stukture wybrac.
        // Aby rozwiazac zadanie przyjelam, ze zwracam kolor i strukture pierwszego elementu.
        if(blocks.size() == 0){
            return null;
        }
        return blocks.get(0).getColor();
    }

    @Override
    public String getMaterial() {
        if(blocks.size() == 0){
            return null;
        }
        return blocks.get(0).getMaterial();
    }

    @Override
    public List<Block> getBlocks() {
        return blocks;
    }
}
