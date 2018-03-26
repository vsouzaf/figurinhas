package br.com.vsouzaf.figurinhas.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.vsouzaf.figurinhas.constant.AlbumCopaEnum;
import br.com.vsouzaf.figurinhas.entity.Album;
import br.com.vsouzaf.figurinhas.entity.FigurinhaAlbum;
import br.com.vsouzaf.figurinhas.entity.Perfil;
import br.com.vsouzaf.figurinhas.entity.Usuario;
import br.com.vsouzaf.figurinhas.repository.AlbumRepository;
import br.com.vsouzaf.figurinhas.repository.FigurinhaAlbumRepository;
import br.com.vsouzaf.figurinhas.repository.PerfilRepository;
import br.com.vsouzaf.figurinhas.repository.UsuarioRepository;

@Component
public class CargaInicial  implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    UsuarioRepository usuarioRepository;
    
    @Autowired
    PerfilRepository perfilRepository;
    
    @Autowired
    AlbumRepository albumRepository;
    
    @Autowired
    FigurinhaAlbumRepository figurinhaAlbumRepository;
    
    @Override
    public void onApplicationEvent(ContextRefreshedEvent e) {
        List<Perfil> perfis = perfilRepository.findAll();
        
        if(perfis.isEmpty()){
            perfilRepository.save(new Perfil("ROLE_ADMIN"));
            
            Perfil perfil = perfilRepository.findByNome("ROLE_ADMIN");
            
            List<Perfil> perfisUsuario = new ArrayList<Perfil>();
            
            perfisUsuario.add(perfil);
            
            usuarioRepository.save(new Usuario("Valtemir Souza", perfisUsuario, "vsouzaf", "12345"));
        }
    	
        Album album = albumRepository.findByNome(AlbumCopaEnum.NOME_ALBUM.getDescricao());
        
        if(album == null) {
        	album = new Album();
        	album.setNome(AlbumCopaEnum.NOME_ALBUM.getDescricao());
    		ArrayList<FigurinhaAlbum> figurinhaAlbums = new ArrayList<FigurinhaAlbum>();
    		
    		album = albumRepository.save(album);
    		
    		for(Integer numFigurinha = 1; numFigurinha <= AlbumCopaEnum.NOME_ALBUM.getQuantidade(); numFigurinha++) {
    			FigurinhaAlbum figurinhaAlbum = new FigurinhaAlbum();
    			figurinhaAlbum.setAlbum(album);
    			figurinhaAlbum.setNumero(numFigurinha.toString());
    			figurinhaAlbum = figurinhaAlbumRepository.save(figurinhaAlbum);
    			figurinhaAlbums.add(figurinhaAlbum);
    		}
    		
    		album.setFigunhasDoAlbum(figurinhaAlbums);
    		
    		albumRepository.save(album);
        }
    }
    
}
