/*
this will hold our homepage image
alt with the image is used as an alternative incase the image does not load
 */
import React from 'react';

function HomepageImage(){
    const url = 'https://cdn.filestackcontent.com/XYrHCaFGRSaq0EPKY1S6';
    return(
        <img src={url} style={{width: 650}} alt='Image of bridge aesthetic' />
    );
}

export default HomepageImage;