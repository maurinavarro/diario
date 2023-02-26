import React from "react";

const Secondarysection = () => {

return (
<div className="main grid grid-cols-1 gap-8 md:grid-cols-3 mx-5 md:gap-5 md:mx-4 lg:mx-6 xl:mx-6 2xl:mx-20">
    <div className="">
        <img className="h-72 w-full object-cover md:w-full md:h-2/4" src="../public/pt2-5.jpg" alt="" />
        <a className="category font-crimson font-semibold text-sm text-[#2c9995] xl:text-base" href="">Category</a>
        <h2 className="font-poppins font-semibold text-lg pt-1.5 md:text-sm lg:text-sm xl:text-lg">Título de la noticia 1</h2>
        <p className="font-crimson font-normal text-sm text-gray-400 pt-1">Hora de la publicación</p>
    </div>
    <div className="">
        <img className="h-72 w-full object-cover md:w-full md:h-2/4" src="../public/img7.jpg" alt="" />
        <a className="category font-crimson font-semibold text-sm text-[#2c9995] xl:text-base" href="">Category</a>
        <h2 className="font-poppins font-semibold text-lg pt-1.5 md:text-sm lg:text-sm xl:text-lg">Título de la noticia 2</h2>
        <p className="font-crimson font-normal text-sm text-gray-400 pt-1">Hora de la publicación</p>
    </div>
    <div className="">
        <img className="h-72 w-full object-cover md:w-full md:h-2/4" src="../public/img8.jpg" alt="" />
        <a className="category font-crimson font-semibold text-sm text-[#2c9995] xl:text-base" href="">Category</a>
        <h2 className="font-poppins font-semibold text-lg pt-1.5 md:text-sm lg:text-sm xl:text-lg">Título de la noticia 3</h2>
        <p className="font-crimson font-normal text-sm text-gray-400 pt-1">Hora de la publicación</p>
    </div>
</div>
)
};

export default Secondarysection;
